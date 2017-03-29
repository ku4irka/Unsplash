package com.ku4irka.unsplash.presenter.authenticate;

import android.webkit.WebViewClient;

/**
 * Created by Pavlo Kuchirka on 16-Mar-17.
 */

public interface AuthPresenter {

    WebViewClient getWebViewClient();

    String getLoginUrl();

    void getAccessToken(String code);
}
