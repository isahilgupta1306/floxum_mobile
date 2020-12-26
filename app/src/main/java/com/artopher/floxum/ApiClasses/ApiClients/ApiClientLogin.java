package com.artopher.floxum.ApiClasses.ApiClients;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientLogin {

    private static final String BASE_URL="https://floxum-backend.herokuapp.com/" ;
    private static ApiClientLogin minstance;
    private Retrofit retrofit;

    private ApiClientLogin(){

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ApiClientLogin getInstance(){
        if (minstance==null){
            minstance = new ApiClientLogin();
        }
        return  minstance;
    }

    public LoginService getApi(){

        return retrofit.create(LoginService.class);
    }
}
