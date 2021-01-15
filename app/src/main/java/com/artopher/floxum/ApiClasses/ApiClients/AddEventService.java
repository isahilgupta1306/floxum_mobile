package com.artopher.floxum.ApiClasses.ApiClients;

import android.media.Image;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddEventService {

    //For
    @FormUrlEncoded
    @POST("event/add/")
    Call<ResponseBody> AddEvent(
            @Field("name") String eventTitle,
            @Field("link") String link,
            @Field("location") String location,
            @Field("contact") String contact,
            @Field("date") String date,
            @Field("time") String time,
            @Field("description") String description,
            @Field("image")Image image
            );
}
