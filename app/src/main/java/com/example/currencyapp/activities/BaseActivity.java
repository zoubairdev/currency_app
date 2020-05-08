package com.example.currencyapp.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.currencyapp.injection.component.ActivityComponent;
import com.example.currencyapp.injection.component.DaggerActivityComponent;
import com.example.currencyapp.injection.module.ActivityModule;
import com.example.currencyapp.utils.base.MyApp;


public class BaseActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    /**
     * Used for dependency injection
     *
     * @return {@link ActivityComponent} which is used for injection
     */
    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MyApp.get(this).component())
                    .build();
        }
        return activityComponent;

    }

}

