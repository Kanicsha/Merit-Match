package com.example.kd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class Authenticator_Token implements Authenticator {

    private ApiService apiService;

    TokenStorage token;

    public Authenticator_Token(TokenStorage Token) {
        this.token=Token;

    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        String access_token=token.getToken();
        return response.request().newBuilder()
                .header("Authorization", "Bearer " + access_token)
                .build();
    }
}
