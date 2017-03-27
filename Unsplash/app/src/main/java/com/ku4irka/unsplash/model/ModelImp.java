package com.ku4irka.unsplash.model;

import com.ku4irka.unsplash.model.dto.authorization.AccessTokenDTO;
import com.ku4irka.unsplash.model.dto.authorization.PostTokenDTO;
import com.ku4irka.unsplash.model.service.OAuthService;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

import static com.ku4irka.unsplash.app.Const.IO_THREAD;
import static com.ku4irka.unsplash.app.Const.UI_THREAD;


/**
 * Created by Pavlo Kuchirka on 12-Mar-17.
 */

public class ModelImp implements Model {

    @Inject
    OAuthService mOAuthService;

    @Inject
    @Named(UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(IO_THREAD)
    Scheduler ioThread;

    public ModelImp() {
//        AppApplication.getInstance().getMVPComponent().inject(this);
//        AppApplication.getInstance().getApiComponent().inject(this);
    }

    @Override
    public Observable<AccessTokenDTO> getAccessToken(PostTokenDTO tokenDTO) {
        return mOAuthService
                .getAccessToken(tokenDTO)
                .subscribeOn(ioThread)
                .observeOn(uiThread);
    }
}