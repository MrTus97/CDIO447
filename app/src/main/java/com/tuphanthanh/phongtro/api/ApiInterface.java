package com.tuphanthanh.phongtro.api;

import com.tuphanthanh.phongtro.feature.login.model.LoginResult;
import com.tuphanthanh.phongtro.feature.users.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("api/login.php")
    Call<LoginResult> login(@Field("tendangnhap") String email,
                               @Field("matkhau") String password);

    @Headers("Content-Type: application/json")
    @GET("api/getowner.php")
    Call<UserResponse> getOwner();

    @GET("api/getrenter.php")
    Call<UserResponse> getRenter();
}
