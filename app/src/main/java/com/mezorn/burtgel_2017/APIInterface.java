package com.mezorn.burtgel_2017;

import com.mezorn.burtgel_2017.models.UserRequest;
import com.mezorn.burtgel_2017.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by manlai on 5/28/17.
 */

interface APIInterface {

   // @GET("/api/unknown")
    //Call<MultipleResource> doGetListResources();

    @POST("/managers/login/")
    Call<UserResponse> createUser(@Body UserRequest user);

    //@GET("/api/users?")
    //Call<UserList> doGetUserList(@Query("page") String page);

    //@FormUrlEncoded
    //@POST("/api/users?")
    //Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}