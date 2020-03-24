package com.sweetzpot.stravazpot.authenticaton.request;

import retrofit2.Call;
import com.sweetzpot.stravazpot.authenticaton.api.AuthenticationAPI;
import com.sweetzpot.stravazpot.authenticaton.model.AppCredentials;
import com.sweetzpot.stravazpot.authenticaton.model.LoginResult;
import com.sweetzpot.stravazpot.authenticaton.rest.AuthenticationRest;


public class AuthenticationRefreshRequest {

    private final AppCredentials appCredentials;
    private final AuthenticationRest restService;
    private final AuthenticationAPI api;
    private String refreshToken;

    public AuthenticationRefreshRequest(AppCredentials appCredentials, AuthenticationRest restService, AuthenticationAPI api) {
        this.appCredentials = appCredentials;
        this.restService = restService;
        this.api = api;
    }

    public AuthenticationRefreshRequest withRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public LoginResult execute() {
        Call<LoginResult> call = restService.refreshToken(appCredentials.getClientID(), appCredentials.getClientSecret(), refreshToken, "refresh_token");
        return api.execute(call);
    }
}
