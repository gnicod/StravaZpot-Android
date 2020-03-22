package com.sweetzpot.stravazpot.authenticaton.model;

import com.google.gson.annotations.SerializedName;
import com.sweetzpot.stravazpot.athlete.model.Athlete;

public class LoginResult {
    @SerializedName("access_token") private Token token;
    @SerializedName("refresh_token") private String refreshToken;
    @SerializedName("athlete") private Athlete athlete;

    public String getRefreshToken() { return refreshToken; }

    public Token getToken() {
        return token;
    }

    public Athlete getAthlete() {
        return athlete;
    }
}
