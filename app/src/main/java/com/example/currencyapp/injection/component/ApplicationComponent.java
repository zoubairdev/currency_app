package com.example.currencyapp.injection.component;

import android.app.Application;
import android.content.Context;

import com.example.currencyapp.api.BaseApiManager;
import com.example.currencyapp.api.DataManager;
import com.example.currencyapp.injection.ApplicationContext;
import com.example.currencyapp.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author zoubair
 * @since 07/05/20
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {


    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    BaseApiManager baseApiManager();

}
