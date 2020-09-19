package com.example.daleshprashar.daleprasseptwenty

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface DataService {

    // /photos
    @GET("movies.json")
    fun getAllPhotos(): Call<List<RetroPhoto>>

    @GET("mm")
    fun getDummy(): Call<String>


    @HTTP(method = "POST", path = "readrequestbody", hasBody = true)
     fun postBodyString(@Body stringpassed: String): Call<Object>


// Crashed saying Get should not have a body
//    @HTTP(method = "POST", path = "readrequestbody", hasBody = true)
  //  fun postBodyString(@Body stringpassed: String): Call<String>

    // Passing String  and expecting back String, But Didnt work some Exception
 //   @GET("readrequestbody")
  //  fun postBodyString(@Body stringpassed: String): Call<String>


    @POST("users")
    fun postBodyFull(@Body user: RetroPhoto): Call<RetroPhoto>

    @GET("users")
    fun getUserById(@Query("id") id: Int?, @Query("Fee") fee: Int?): Call<RetroPhoto>

    @GET("users/{name}/commits")
    fun getCallByPath(@Path("name") name: String): Call<String>

    @GET("header")
    fun getCallByHeader(@Header("Authorization") header: String): Call<String>





    //RxJava
    fun getCallRxJava(): Observable<RetroPhoto>

}