package com.example.kd;

import androidx.activity.EdgeToEdge;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static ApiService api;
    static String apiUrl="http://10.0.2.2:8000";

    public static ApiService getClient() {
        TokenStorage tokenStorage=new TokenStorage();
        if (api == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .followRedirects(true) // Add this line
                    .authenticator(new Authenticator_Token(tokenStorage))
                    .build();
            api = new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                    .create(ApiService.class);
        }


        return api;
    }
}
