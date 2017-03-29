package com.ku4irka.unsplash.presenter.authenticate;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ku4irka.unsplash.app.AppApplication;
import com.ku4irka.unsplash.app.Const;
import com.ku4irka.unsplash.app.helper.PreferencesHelper;
import com.ku4irka.unsplash.model.dto.authorization.AccessTokenDTO;
import com.ku4irka.unsplash.model.dto.authorization.PostTokenDTO;
import com.ku4irka.unsplash.presenter.BasePresenter;
import com.ku4irka.unsplash.view.fragments.authenticate.AuthFragmentView;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

import static com.ku4irka.unsplash.app.Const.LOGIN_URL;

/**
 * Created by Pavlo Kuchirka on 13-Mar-17.
 */

public class AuthPresenterImp extends BasePresenter implements AuthPresenter {

    @Inject
    PostTokenDTO mPostTokenDTO;

    PreferencesHelper mPrefHelper;

    private AuthFragmentView mView;

    public AuthPresenterImp(AuthFragmentView view) {
        mView = view;
        AppApplication.getInstance().getMVPComponent().inject(this);
        mPrefHelper = AppApplication.getInstance().getAppComponent().preferencesHelper();
    }

    @Override
    public WebViewClient getWebViewClient() {
        return new WebViewClient() {
            // if you use api >= 21, you can use shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);

                if (uri.getHost().equals(Const.HOST_URL)
                        && uri.getPath().contains("oauth/authorize")
                        && uri.getQueryParameter("client_id") == null) {
                    String code = uri.getLastPathSegment();
                    getAccessToken(code);

                    return true; //Indicates WebView to NOT load the url;
                }
                return false; //Allow WebView to load url
            }
        };
    }

    @Override
    public String getLoginUrl() {
      return String.format(LOGIN_URL, AppApplication.getInstance().getClientId());
    }

    @Override
    public void getAccessToken() {

    }

    @Override
    public void getAccessToken(String code) {
        mPostTokenDTO.setCode(code);

        Disposable disposable = mDataModel.getAccessToken(mPostTokenDTO)
            .subscribeWith(new DisposableObserver<AccessTokenDTO>() {
              @Override
              public void onNext(AccessTokenDTO accessToken) {
                  if (accessToken != null) {
                      String token = accessToken.getAccessToken();
                      mPrefHelper.saveToken(token);

                      mView.goToMainFragment();
                  }
              }

              @Override
              public void onError(Throwable e) {

              }

              @Override
              public void onComplete() {

              }
          });
    }
}
