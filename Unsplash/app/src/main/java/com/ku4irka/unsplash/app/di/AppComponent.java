package com.ku4irka.unsplash.app.di;

import android.content.Context;

import com.ku4irka.unsplash.app.di.helper.UtilModule;
import com.ku4irka.unsplash.app.helper.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pavlo Kuchirka on 20-Mar-17.
 */

@Singleton
@Component(modules = {AppModule.class, UtilModule.class})
public interface AppComponent {

    void inject(Context context);

    PreferencesHelper preferencesHelper();
}
