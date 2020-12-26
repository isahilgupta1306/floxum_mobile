package com.artopher.floxum.ApiClasses.ApiClients;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    //For login
    @FormUrlEncoded
    @POST("login/")
    Call<ResponseBody> login(
            @Field("password") String password,
            @Field("email") String email
    );
}
