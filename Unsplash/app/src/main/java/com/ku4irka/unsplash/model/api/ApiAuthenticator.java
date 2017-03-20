package com.ku4irka.unsplash.model.api;

import android.content.Context;

import com.ku4irka.unsplash.model.dto.authorization.AccessTokenDTO;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by Pavlo Kuchirka on 12-Mar-17.
 */

public class ApiAuthenticator implements Authenticator {

    private Context mContext;
    private AccessTokenDTO mToken;

    public ApiAuthenticator(Context context, AccessTokenDTO accessToken) {
        mContext = context;
    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
//        if(responseCount(response) >= 2)
            return null;

//        ApiClient tokenClient = createService(ApiClient.class);
//        Call<AccessTokenDTO> call = tokenClient.getRefreshAccessToken(
//                mToken.getRefreshToken(), mToken.getClientID(), mToken.getClientSecret(), API_OAUTH_REDIRECT, "refresh_token");
//        try {
//            retrofit2.Response<AccessTokenDTO> tokenResponse = call.execute();
//            if(tokenResponse.code() == 200) {
//                AccessTokenDTO newToken = tokenResponse.body();
//                mToken = newToken;
//                SharedPreferences prefs = mContext.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
//                prefs.edit().putBoolean("oauth.loggedin", true).apply();
//                prefs.edit().putString("oauth.accesstoken", newToken.getAccessToken()).apply();
//                prefs.edit().putString("oauth.refreshtoken", newToken.getRefreshToken()).apply();
//                prefs.edit().putString("oauth.tokentype", newToken.getTokenType()).apply();
//
//                return response.request().newBuilder()
//                        .header("Authorization", newToken.getTokenType() + " " + newToken.getAccessToken())
//                        .build();
//            } else {
//                return null;
//            }
//        } catch(IOException e) {
//            return null;
//        }
    };

    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }
}
