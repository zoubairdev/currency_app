package com.example.currencyapp.injection.module;

import android.app.Application;
import android.content.Context;

import com.example.currencyapp.injection.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author zoubair
 * @since 07/05/20
 */
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }


}
