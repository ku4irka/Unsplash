package com.ku4irka.unsplash.app.di.mvp;

import com.ku4irka.unsplash.app.AppApplication;
import com.ku4irka.unsplash.app.di.scope.MVPScope;
import com.ku4irka.unsplash.model.dto.authorization.PostTokenDTO;

import dagger.Module;
import dagger.Provides;

import static com.ku4irka.unsplash.app.Const.REDIRECT_URI;

/**
 * Created by Pavlo Kuchirka on 26-Mar-17.
 */

@Module
public class PresenterModule {

    private static final String PREF_AUTH_CODE = "authorization_code";

    @Provides
    @MVPScope
    PostTokenDTO provideTokenData() {
        return new PostTokenDTO(
                AppApplication.getInstance().getClientId(),
                AppApplication.getInstance().getClientSecret(),
                REDIRECT_URI,
                PREF_AUTH_CODE
        );
    }
}
