package com.ku4irka.unsplash.app;

public final class Const {

    private Const() {}

    // APP
    public static final String APP_SCHEME = "app";
    public static final String APP_HOST = "io.github.ku4irka.unsplash";

    // API
    public static final String SCHEME_URL = "https://";
    public static final String HOST_URL = "unsplash.com";
    public static final String OAUTH_URL = SCHEME_URL + HOST_URL;
    public static final String API_URL = "https://api.unsplash.com";
    public static final String API_VERSION = "v1";
    public static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
    //    public static final String REDIRECT_URI = APP_SCHEME + "%3A%2F%2F" + APP_HOST + "/oauth/authorize";

    public static final String LOGIN_URL = OAUTH_URL
            + "/oauth/authorize"
            + "?client_id=%s"
            + "&redirect_uri="
            + REDIRECT_URI
            + "&response_type=code"
            + "&scope=public";
//            "&scope=public+read_user+read_photos+read_collections+write_likes+write_followers";

    // DI
    public static final String UI_THREAD = "UI_THREAD";
    public static final String IO_THREAD = "IO_THREAD";
}
