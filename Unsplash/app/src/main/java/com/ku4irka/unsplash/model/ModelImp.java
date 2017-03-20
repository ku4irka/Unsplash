package com.ku4irka.unsplash.model;

import com.ku4irka.unsplash.app.AppApplication;
import com.ku4irka.unsplash.model.api.ApiClient;
import com.ku4irka.unsplash.model.api.ServiceGenerator;
import com.ku4irka.unsplash.model.dto.authorization.AccessTokenDTO;
import com.ku4irka.unsplash.model.dto.authorization.PostTokenDTO;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.ku4irka.unsplash.app.Const.REDIRECT_URI;


/**
 * Created by Pavlo Kuchirka on 12-Mar-17.
 */

public class ModelImp implements Model {

    private ApiClient mApiClient = ServiceGenerator.createService(ApiClient.class);

    @Override
    public Observable<AccessTokenDTO> getAccessToken(String code) {
        return mApiClient.getAccessToken(getTokenData(code))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private PostTokenDTO getTokenData(String code) {
        PostTokenDTO token = new PostTokenDTO();
        token.setClientId(AppApplication.getInstance().getClientId());
        token.setClientSecret(AppApplication.getInstance().getClientSecret());
        token.setRedirectUri(REDIRECT_URI);
        token.setCode(code);
        token.setGrantType("authorization_code");

        return token;
    }

}
