package com.ku4irka.unsplash.app.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pavlo Kuchirka on 25-Mar-17.
 */

@Module
public class AppModule {

    private final Context mContext;

    public AppModule(@NonNull Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }
}
