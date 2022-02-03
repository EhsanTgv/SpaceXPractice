package com.taghavi.spacexpractice.network;

import com.taghavi.spacexpractice.model.LaunchModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("latest")
    Call<LaunchModel> getLatest();
}
