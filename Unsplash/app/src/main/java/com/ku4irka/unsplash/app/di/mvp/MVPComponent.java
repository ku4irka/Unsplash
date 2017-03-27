package com.ku4irka.unsplash.app.di.mvp;

import com.ku4irka.unsplash.app.di.scope.MVPScope;
import com.ku4irka.unsplash.model.ModelImp;
import com.ku4irka.unsplash.presenter.authenticate.AuthPresenterImp;

import dagger.Component;

/**
 * Created by Pavlo Kuchirka on 26-Mar-17.
 */

@MVPScope
@Component(
        modules = {
                ModelModule.class,
                ViewModule.class,
                PresenterModule.class
        }
)
public interface MVPComponent {

    void inject(ModelImp modelImp);

    void inject(AuthPresenterImp authPresenterImp);
}