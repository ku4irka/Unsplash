package com.ku4irka.unsplash.app;

import android.app.Application;
import android.util.Log;

import com.ku4irka.unsplash.app.di.AppComponent;
import com.ku4irka.unsplash.app.di.AppModule;
import com.ku4irka.unsplash.app.di.DaggerAppComponent;
import com.ku4irka.unsplash.app.di.api.ApiComponent;
import com.ku4irka.unsplash.app.di.api.ApiModule;
import com.ku4irka.unsplash.app.di.api.DaggerApiComponent;
import com.ku4irka.unsplash.app.di.helper.UtilModule;
import com.ku4irka.unsplash.app.di.mvp.DaggerMVPComponent;
import com.ku4irka.unsplash.app.di.mvp.MVPComponent;
import com.ku4irka.unsplash.app.di.mvp.ModelModule;
import com.ku4irka.unsplash.app.di.mvp.PresenterModule;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Pavlo Kuchirka on 15-Mar-17.
 */

public class AppApplication extends Application {

    private static AppApplication sInstance;

    private String mClientId;
    private String mClientSecret;

    private AppComponent mAppComponent;
    private MVPComponent mMVPComponent;
    private ApiComponent mApiComponent;

    public static AppApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        initClientProperties();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);

        mMVPComponent = DaggerMVPComponent.builder()
                .modelModule(new ModelModule())
                .build();
        mApiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .build();

    }

    public String getClientId() {
        return mClientId;
    }

    public String getClientSecret() {
        return mClientSecret;
    }

    public MVPComponent getMVPComponent() {
        return mMVPComponent;
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

    private void initClientProperties() {
        // Private config
        Properties properties = new Properties();
        try {
            properties.load(getAssets().open("private.properties"));

            mClientId = properties.getProperty("client.id");
            mClientSecret = properties.getProperty("client.secret");
        } catch (IOException e) {
            Log.d("Properties", e.getMessage());
            e.printStackTrace();
        }
    }
}
