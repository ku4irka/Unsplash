package com.ku4irka.unsplash.model.dto.authorization;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostTokenDTO {

    @SerializedName("client_id")
    @Expose
    private String clientId;

    @SerializedName("client_secret")
    @Expose
    private String clientSecret;

    @SerializedName("redirect_uri")
    @Expose
    private String redirectUri;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("grant_type")
    @Expose
    private String grantType;

    public PostTokenDTO(String clientId, String clientSecret, String redirectUri, String grantType) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.grantType = grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
