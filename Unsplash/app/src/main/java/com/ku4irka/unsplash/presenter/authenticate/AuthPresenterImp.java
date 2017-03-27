package com.ku4irka.unsplash.presenter.authenticate;

import com.ku4irka.unsplash.app.AppApplication;
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
        mPostTokenDTO.setCode(code);

        Disposable disposable = mDataModel.getAccessToken(mPostTokenDTO)
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
