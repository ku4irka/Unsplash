package com.ku4irka.unsplash.presenter.authenticate;

import com.ku4irka.unsplash.app.AppApplication;
import com.ku4irka.unsplash.model.dto.authorization.AccessTokenDTO;
import com.ku4irka.unsplash.presenter.BasePresenter;
import com.ku4irka.unsplash.view.fragments.authenticate.AuthFragmentView;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

import static com.ku4irka.unsplash.app.Const.LOGIN_URL;

/**
 * Created by Pavlo Kuchirka on 13-Mar-17.
 */

public class AuthPresenterImp extends BasePresenter implements AuthPresenter {

    private AuthFragmentView mView;

    public AuthPresenterImp(AuthFragmentView view) {
        mView = view;
    }

    @Override
    public void getLoginUrl() {
        mView.setWebView(String.format(LOGIN_URL, AppApplication.getInstance().getClientId()));
    }

    @Override
    public void getAccessToken() {

    }

    @Override
    public void getAccessToken(String code) {
//        String link = "https://unsplash.com/oauth/authorize?client_id=f29d9ba6eb38f3e54e7bc782a9a4e6ee28ab3f6a5f005d3640444d62cc240339&client_secret=e282d3780134c7ad2e55a4c532e86638fd036e37d0f1487c196caa4626c41b19&redirect_uri=ku4irka://unsplash&scope=public&grant_type=client_credentials";
//        String link = "https://unsplash.com/oauth/token/?client_id=f29d9ba6eb38f3e54e7bc782a9a4e6ee28ab3f6a5f005d3640444d62cc240339&client_secret=e282d3780134c7ad2e55a4c532e86638fd036e37d0f1487c196caa4626c41b19&redirect_uri=ku4irka://unsplash&code=e374877b2fb66fbf311c31a4850ae5dd229124e2bc909ad53ff6c1fd2b053254&grant_type=authorization_code";

        Disposable disposable = mDataModel.getAccessToken(code)
                .subscribeWith(new DisposableObserver<AccessTokenDTO>() {
                    @Override
                    public void onNext(AccessTokenDTO accessToken) {
                        if (accessToken != null) {
                            String token = accessToken.getAccessToken();
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
