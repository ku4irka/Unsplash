package com.ku4irka.unsplash.presenter.authenticate;

/**
 * Created by Pavlo Kuchirka on 16-Mar-17.
 */

public interface AuthPresenter {

    void getLoginUrl();

    void getAccessToken(String code);
}
