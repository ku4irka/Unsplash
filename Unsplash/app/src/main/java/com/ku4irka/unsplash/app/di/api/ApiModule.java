package com.ku4irka.unsplash.app.di.api;

import com.ku4irka.unsplash.app.Const;
import com.ku4irka.unsplash.app.di.scope.ApplicationScope;
import com.ku4irka.unsplash.app.helper.PreferencesHelper;
import com.ku4irka.unsplash.model.service.OAuthService;

import java.io.IOException;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pavlo Kuchirka on 12-Mar-17.
 */

@Module
public class ApiModule {

    //private static final boolean ENABLE_LOG = true;
    //
    //private static final boolean ENABLE_AUTH = false;

    //private static OkHttpClient.Builder sHttpClient = new OkHttpClient.Builder();
    //
    //private static Retrofit.Builder builder = new Retrofit.Builder()
    //    .baseUrl(OAUTH_URL)
    //    .addConverterFactory(GsonConverterFactory.create())
    //    .addCallAdapterFactory(RxJava2CallAdapterFactory.create());


    //public static <S> S createService(Class<S> serviceClass) {
    //    OkHttpClient client = sHttpClient.build();
    //    Retrofit retrofit = builder.client(client).build();
    //
    //    return retrofit.create(serviceClass);
    //}

    @Provides
    @ApplicationScope
    Interceptor provideIterceptor(PreferencesHelper prefHelper) {
        return chain -> {
            try {
                Request original = chain.request();
                Request.Builder builder = original.newBuilder();

                String token = prefHelper.getToken();
                if (token != null) {
                    builder.addHeader("Authorization", "Bearer " + token);
                }

                Request request = builder.build();

                return chain.proceed(request);
            } catch (IOException e) {
                throw e;
            }
        };
    }

    @Provides
    @ApplicationScope
    OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(OkHttpClient httpClient) {
        return provideRetrofit(httpClient, Const.API_URL);
    }

    @Provides
    @ApplicationScope
    @Named("oauth")
    Retrofit provideOAuthRetrofit(OkHttpClient httpClient) {
        return provideRetrofit(httpClient, Const.OAUTH_URL);
    }

    private Retrofit provideRetrofit(OkHttpClient httpClient, String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    OAuthService provideOAuthService(@Named("oauth") Retrofit retrofit) {
        return retrofit.create(OAuthService.class);
    }

//    public static OAuthService getOauthService(String url, PostTokenDTO postTokenDTO) {
//
//        OkHttpClient httpClient = new OkHttpClient();
//
//        if (postTokenDTO != null) {
//            httpClient.interceptors().add(chain -> {
//                Request original = chain.request();
//                Request request = original.newBuilder()
//                    .header("Authorization", "Bearer " + postTokenDTO.getCode())
//                    .method(original.method(), original.body())
//                    .build();
//
//                return chain.proceed(request);
//            });
//        }
//
//        if (ENABLE_LOG) {
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            httpClient.interceptors().add(interceptor);
//        }
//
//        Retrofit.Builder builder = new Retrofit.Builder().
//            baseUrl(url)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
//
//        builder.client(httpClient);
//
//        return builder.build().create(OAuthService.class);
//    }

}
