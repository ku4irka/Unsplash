package com.ku4irka.unsplash.model.service;

import com.ku4irka.unsplash.model.dto.authorization.AccessTokenDTO;
import com.ku4irka.unsplash.model.dto.authorization.PostTokenDTO;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Pavlo Kuchirka on 12-Mar-17.
 */

public interface OAuthService {

    @POST("/oauth/token")
    Observable<AccessTokenDTO> getAccessToken(@Body PostTokenDTO token);
}
