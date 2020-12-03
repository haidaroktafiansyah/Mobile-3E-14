package com.haidar.mulchoqu.retrofit;

import com.haidar.mulchoqu.model.SoalModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("api.php?amount=20&category=27&difficulty=medium&type=multiple")
    Call<SoalModel> getData();
}
