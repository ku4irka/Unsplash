package com.ku4irka.unsplash.model;

import com.ku4irka.unsplash.model.dto.authorization.AccessTokenDTO;
import com.ku4irka.unsplash.model.dto.authorization.PostTokenDTO;

import io.reactivex.Observable;

/**
 * Created by Pavlo Kuchirka on 12-Mar-17.
 */

public interface Model {

    Observable<AccessTokenDTO> getAccessToken(PostTokenDTO tokenDTO);
}
