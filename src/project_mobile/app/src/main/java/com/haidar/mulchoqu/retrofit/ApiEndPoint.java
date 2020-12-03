package com.haidar.mulchoqu.retrofit;

import com.haidar.mulchoqu.model.ApiModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("users/list?sort=desc")
    Call<ApiModel> getData();
}
