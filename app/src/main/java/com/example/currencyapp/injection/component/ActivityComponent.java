package com.example.currencyapp.injection.component;


import com.example.currencyapp.activities.CurrencyListActivity;
import com.example.currencyapp.activities.HistoryChartActivity;
import com.example.currencyapp.injection.PerActivity;
import com.example.currencyapp.injection.module.ActivityModule;

import dagger.Component;

/**
 * @author zoubair
 * @since 07/05/20
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(CurrencyListActivity currencyListActivity);

    void inject(HistoryChartActivity historyChartActivity);
}
