package com.example.currencyapp.activities;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.currencyapp.R;
import com.example.currencyapp.models.SingleDateValue;
import com.example.currencyapp.presenters.CurrencyPresenter;
import com.example.currencyapp.utils.AppConstants;
import com.example.currencyapp.utils.AppUtils;
import com.example.currencyapp.views.CurrencyView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryChartActivity extends BaseActivity implements CurrencyView {

    @BindView(R.id.history_rates_chart)
    LineChart chart;
    @BindView(R.id.selected_currency)
    TextView selectedCurrency;
    @Inject
    CurrencyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_chart);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        presenter.attachView(this);
        init();
    }

    void init() {
        Date endDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        cal.add(Calendar.DATE, -60);
        Date startDate = cal.getTime();
        selectedCurrency.setText(getIntent().getExtras().getString(AppConstants.SYMBOL_KEY));
        presenter.getCurrencyHistoryRatesFromApi(getIntent().getExtras().getString(AppConstants.SYMBOL_KEY), AppUtils.formatToInverseDate(startDate), AppUtils.formatToInverseDate(endDate));
    }


    @Override
    public void currencyHistoryRatesReady(List<SingleDateValue> historyRates) {
        if (historyRates != null) {
            Collections.sort(historyRates, (o1, o2) -> o1.getDate().compareTo(o2.getDate()));
            List<Entry> entries = new ArrayList<>();
            List<String> xAxisValues = new ArrayList<>();
            int i = 0;
            for (SingleDateValue single : historyRates) {
                // turn your data into Entry objects
                entries.add(new Entry(i, Float.parseFloat(single.getRate())));
                xAxisValues.add(AppUtils.formatToStandardDate(single.getDate()));
                i++;
            }
            configureChartAxisEntries(entries, xAxisValues);
        }
    }


    void configureChartAxisEntries(List<Entry> entries, List<String> xAxisValues) {
        LineDataSet dataSet = new LineDataSet(entries, "");
        dataSet.setColor(getResources().getColor(R.color.colorPrimaryDark));
        dataSet.setValueTextColor(getResources().getColor(R.color.colorPrimary));
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setFillAlpha(65);
        dataSet.setFillColor(Color.RED);
        dataSet.setCircleColor(Color.RED);
        dataSet.setLineWidth(2f);
        dataSet.setCircleSize(5f);
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.getXAxis().setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(xAxisValues));
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getXAxis().setLabelRotationAngle(90);
        chart.getXAxis().setTextSize(12f);
        chart.getXAxis().setTextColor(Color.BLACK);
        chart.getAxis(YAxis.AxisDependency.RIGHT).setEnabled(false);
        chart.getXAxis().setDrawAxisLine(true);
        chart.getLegend().setEnabled(false);
        chart.notifyDataSetChanged();
        chart.invalidate();
    }

}
