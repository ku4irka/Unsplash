package com.ku4irka.unsplash.app.di.api;

import com.ku4irka.unsplash.app.di.AppComponent;
import com.ku4irka.unsplash.app.di.scope.ApplicationScope;
import com.ku4irka.unsplash.model.service.OAuthService;

import dagger.Component;

/**
 * Created by Pavlo Kuchirka on 26-Mar-17.
 */

@ApplicationScope
@Component(
        modules = ApiModule.class,
        dependencies = AppComponent.class
)
public interface ApiComponent {

//    void inject(ModelImp modelImp);
    OAuthService oauthService();
}
