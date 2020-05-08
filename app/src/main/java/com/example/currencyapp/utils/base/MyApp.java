package com.example.currencyapp.utils.base;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.example.currencyapp.injection.component.ApplicationComponent;
import com.example.currencyapp.injection.component.DaggerApplicationComponent;
import com.example.currencyapp.injection.module.ApplicationModule;


/**
 * @author zoubair
 * @since 07/05/20
 */
public class MyApp extends MultiDexApplication {

    ApplicationComponent applicationComponent;

    private static MyApp instance;

    public static MyApp get(Context context) {
        return (MyApp) context.getApplicationContext();
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        //Fabric.with(this, new Crashlytics());
        instance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public ApplicationComponent component() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return applicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
