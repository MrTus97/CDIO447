package com.tuphanthanh.phongtro.api;

import com.tuphanthanh.phongtro.login.model.LoginResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("api/login.php")
    Call<LoginResult> login(@Field("tendangnhap") String email,
                               @Field("matkhau") String password);
}
