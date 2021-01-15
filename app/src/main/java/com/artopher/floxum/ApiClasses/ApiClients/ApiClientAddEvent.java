package com.artopher.floxum.ApiClasses.ApiClients;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientAddEvent {

    private static final String BASE_URL="https://floxum-backend.herokuapp.com/" ;
    private static ApiClientAddEvent minstance;
    private Retrofit retrofit;

    private ApiClientAddEvent(){

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ApiClientAddEvent getInstance(){
        if (minstance==null){
            minstance = new ApiClientAddEvent();
        }
        return  minstance;
    }

    public AddEventService getApi(){

        return retrofit.create(AddEventService.class);
    }

}
