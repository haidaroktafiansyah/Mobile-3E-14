package com.haidar.mulchoqu.retrofit;

import android.util.Log;

import com.haidar.mulchoqu.model.kategori.Kategori;
import com.haidar.mulchoqu.model.kategori.TriviaCategoryModel;
import com.haidar.mulchoqu.model.soal.SoalModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiEndPoint {
    @GET("api.php?amount=20&category=27&difficulty=medium&type=multiple")
    Call<SoalModel> getData();

    @GET()
    Call<SoalModel> getSoal(@Url String url);

    @GET("api_category.php")
    Call<Kategori> getKategori();


}
