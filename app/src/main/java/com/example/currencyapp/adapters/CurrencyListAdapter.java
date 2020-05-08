package com.example.currencyapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyapp.R;
import com.example.currencyapp.activities.HistoryChartActivity;
import com.example.currencyapp.models.Currency;
import com.example.currencyapp.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.ViewHolder> {

    private List<Currency> currencyList;
    private static Context context;

    public CurrencyListAdapter(Context context, List<Currency> currencyList) {
        this.currencyList = currencyList;
        CurrencyListAdapter.context = context;

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.currency_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Currency currency = this.currencyList.get(position);
        holder.txtCurrencySymbol.setText(currency.getSymbol());
        holder.txtCurrencyRate.setText(currency.getRate());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, HistoryChartActivity.class);
            intent.putExtra(AppConstants.SYMBOL_KEY, currency.getSymbol());
            context.startActivity(intent);
        });
    }

    public class Listener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_currency_rate)
        TextView txtCurrencyRate;
        @BindView(R.id.txt_currency_symbol)
        public TextView txtCurrencySymbol;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        CurrencyListAdapter.context = context;
    }

}


