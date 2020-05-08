package com.example.currencyapp.presenters;

import android.content.Context;
import android.util.Log;

import com.example.currencyapp.R;
import com.example.currencyapp.api.DataManager;
import com.example.currencyapp.injection.ApplicationContext;
import com.example.currencyapp.models.Currency;
import com.example.currencyapp.models.CurrencyListResponse;
import com.example.currencyapp.models.HistoryRatesResponse;
import com.example.currencyapp.models.SingleDateValue;
import com.example.currencyapp.views.CurrencyView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CurrencyPresenter extends BasePresenter<CurrencyView> {

    private DataManager dataManager;
    private CompositeDisposable compositeDisposable;


    /**
     * Initialises the AccountsPresenter by automatically injecting an instance of
     * {@link Context} and {@link DataManager} .
     *
     * @param context     Context of the view attached to the presenter.
     * @param dataManager DataManager class that provides access to the data
     *                    via the API.
     */
    @Inject
    public CurrencyPresenter(@ApplicationContext Context context, DataManager dataManager) {
        super(context);
        this.dataManager = dataManager;
        compositeDisposable = new CompositeDisposable();
    }


    // get Currency From Api
    public void getCurrencyListFromApi() {
        checkViewAttached();
        getMvpView().showProgress();
        compositeDisposable.add(dataManager.getCurrencyListCall()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<CurrencyListResponse>() {
                    @Override
                    public void onComplete() {
                        Log.d("APP_DEBUG", "complete");
                        getMvpView().hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(context.getString(R.string.app_name));
                    }

                    @Override
                    public void onNext(CurrencyListResponse currencyResponse) {
                        getMvpView().hideProgress();
                        if (currencyResponse != null) {
                            List<Currency> currencyList = new ArrayList<>();
                            Iterator<Map.Entry<String, String>> iterator = currencyResponse.getRates().entrySet().iterator();
                            Map.Entry<String, String> entry;
                            while (iterator.hasNext()) {
                                Currency currency = new Currency();
                                entry = iterator.next();
                                Log.d("Key Value", entry.getKey() + " " + entry.getValue());
                                currency.setSymbol(entry.getKey());
                                currency.setRate(entry.getValue());
                                currencyList.add(currency);
                            }
                            getMvpView().currencyListReady(currencyList);
                        } else
                            getMvpView().showError(context.getString(R.string.app_name));
                    }
                })
        );
    }

    // get history rate list From Api
    public void getCurrencyHistoryRatesFromApi(String symbol, String startDate, String endDate) {
        checkViewAttached();
        getMvpView().showProgress();
        compositeDisposable.add(dataManager.getCurrencyHistoryRates(symbol, startDate, endDate)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<HistoryRatesResponse>() {
                    @Override
                    public void onComplete() {
                        Log.d("APP_DEBUG", "complete");
                        getMvpView().hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(context.getString(R.string.app_name));
                    }

                    @Override
                    public void onNext(HistoryRatesResponse response) {
                        getMvpView().hideProgress();
                        if (response != null) {
                            List<SingleDateValue> historyList = new ArrayList<>();
                            Iterator<Map.Entry<String, Map<String, String>>> iterator = response.getRates().entrySet().iterator();
                            Map.Entry<String, Map<String, String>> entry;
                            while (iterator.hasNext()) {
                                SingleDateValue single = new SingleDateValue();
                                entry = iterator.next();
                                Log.d("Key_Value", entry.getKey() + " " + entry.getValue().entrySet().iterator().next().getValue());
                                try {
                                    single.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(entry.getKey()));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                single.setRate(entry.getValue().entrySet().iterator().hasNext() ? entry.getValue().entrySet().iterator().next().getValue() : null);
                                historyList.add(single);
                            }
                            getMvpView().currencyHistoryRatesReady(historyList);
                        } else
                            getMvpView().showError(context.getString(R.string.app_name));
                    }
                })
        );
    }


}
