package com.artopher.floxum.ApiClasses.ApiClients;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SignupService {
    //for registering
    @FormUrlEncoded
    @POST("register/")
    Call<ResponseBody> register(
            @Field("username") String username,
            @Field("full_name") String full_name,
            @Field("password") String password,
            @Field("password_r") String password_repeat,
            @Field("email") String email
    );
}
