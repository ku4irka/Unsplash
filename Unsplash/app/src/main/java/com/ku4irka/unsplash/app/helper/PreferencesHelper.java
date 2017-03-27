package com.ku4irka.unsplash.app.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Pavlo Kuchirka on 25-Mar-17.
 */

public class PreferencesHelper {

    private static final String PREF_NAME = "github.ku4irka.unsplash.name";
    private static final String PREF_TOKEN_KEY = "github.ku4irka.unsplash.token";

    private static PreferencesHelper sInstance;
    private SharedPreferences mSharedPreferences;

    private PreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static PreferencesHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesHelper(context);
        }

        return sInstance;
    }

    public void saveToken(String token) {
        mSharedPreferences.edit().putString(PREF_TOKEN_KEY, token).apply();
    }

    public String getToken() {
        return mSharedPreferences.getString(PREF_TOKEN_KEY, null);
    }
}
