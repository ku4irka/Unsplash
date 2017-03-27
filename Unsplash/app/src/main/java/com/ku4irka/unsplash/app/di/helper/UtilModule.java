package com.ku4irka.unsplash.app.di.helper;

import android.content.Context;

import com.ku4irka.unsplash.app.helper.PreferencesHelper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pavlo Kuchirka on 26-Mar-17.
 */

@Module
public class UtilModule {

    @Provides
    static PreferencesHelper providePreferencesHelper(Context context) {
        return PreferencesHelper.getInstance(context);
    }
}
