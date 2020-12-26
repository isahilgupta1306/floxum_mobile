package com.artopher.floxum.ApiClasses.ApiClients;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientSignup {

    private static final String BASE_URL="https://floxum-backend.herokuapp.com/" ;
    private static ApiClientSignup minstance;
    private Retrofit retrofit;

    private ApiClientSignup(){

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ApiClientSignup getInstance(){
        if (minstance==null){
            minstance = new ApiClientSignup();
        }
        return  minstance;
    }

    public SignupService getApi(){

        return retrofit.create(SignupService.class);
    }
}
