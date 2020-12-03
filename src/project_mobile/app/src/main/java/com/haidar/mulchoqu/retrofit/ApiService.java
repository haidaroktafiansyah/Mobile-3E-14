package com.haidar.mulchoqu.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static String BASE_URL = "?amount=20&category=27&difficulty=medium&type=multiple";
    private static Retrofit RETROFIT;
    public static ApiEndPoint endpoint(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return RETROFIT.create(ApiEndPoint.class);
    }



}
