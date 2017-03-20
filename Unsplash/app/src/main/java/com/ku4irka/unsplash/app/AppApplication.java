package com.ku4irka.unsplash.app;

import android.app.Application;
import android.util.Log;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Pavlo Kuchirka on 15-Mar-17.
 */

public class AppApplication extends Application {

    private static AppApplication sInstance;

    private String mClientId;
    private String mClientSecret;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

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

    public static AppApplication getInstance() {
        return sInstance;
    }

    public String getClientId() {
        return mClientId;
    }

    public String getClientSecret() {
        return mClientSecret;
    }

}
