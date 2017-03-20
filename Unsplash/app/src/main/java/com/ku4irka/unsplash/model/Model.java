package com.ku4irka.unsplash.model;

import com.ku4irka.unsplash.model.dto.authorization.AccessTokenDTO;

import io.reactivex.Observable;

/**
 * Created by Pavlo Kuchirka on 12-Mar-17.
 */

public interface Model {

    Observable<AccessTokenDTO> getAccessToken(String authorizationCode);
}
