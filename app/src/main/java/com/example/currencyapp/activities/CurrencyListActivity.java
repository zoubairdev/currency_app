package com.example.currencyapp.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyapp.R;
import com.example.currencyapp.adapters.CurrencyListAdapter;
import com.example.currencyapp.models.Currency;
import com.example.currencyapp.presenters.CurrencyPresenter;
import com.example.currencyapp.views.CurrencyView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyListActivity extends BaseActivity implements CurrencyView {

    @BindView(R.id.rv_currency_list)
    RecyclerView rvCurrencyList;
    CurrencyListAdapter currencyListAdapter;
    LinearLayoutManager llManager;
    @Inject
    CurrencyPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_currency);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        presenter.attachView(this);
        presenter.getCurrencyListFromApi();
    }


    @Override
    public void currencyListReady(List<Currency> currencies) {
        if (currencies != null) {
            llManager = new LinearLayoutManager(this);
            currencyListAdapter = new CurrencyListAdapter(this, currencies);
            rvCurrencyList = findViewById(R.id.rv_currency_list);
            rvCurrencyList.setLayoutManager(llManager);
            rvCurrencyList.setAdapter(currencyListAdapter);
            currencyListAdapter.notifyDataSetChanged();
        }

    }
}
