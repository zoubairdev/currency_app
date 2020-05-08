package com.example.currencyapp.injection.module;

import android.app.Activity;
import android.content.Context;

import com.example.currencyapp.injection.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author zoubair
 * @since 07/05/20
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity providesActivity() {
        return activity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return activity;
    }

}
