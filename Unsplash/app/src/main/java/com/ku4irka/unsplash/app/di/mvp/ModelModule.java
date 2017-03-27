package com.ku4irka.unsplash.app.di.mvp;

import com.ku4irka.unsplash.app.di.scope.MVPScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.ku4irka.unsplash.app.Const.IO_THREAD;
import static com.ku4irka.unsplash.app.Const.UI_THREAD;

/**
 * Created by Pavlo Kuchirka on 22-Mar-17.
 */

@Module
public class ModelModule {

    @Provides
    @MVPScope
    @Named(UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @MVPScope
    @Named(IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }
}
