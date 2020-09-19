package com.example.daleshprashar.daleprasseptwenty

import okhttp3.Interceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException
import retrofit.RxJavaCallAdapterFactory as RxJavaCallAdapterFactory1


class RetrofitClientInstance {
   // private lateinit var retrofit: Retrofit
    private val BASE_URL_2 = "https://jsonplaceholder.typicode.com"
    private val BASE_URL_3 =  "https://api.androidhive.info/json/"
    private val BASE_URL =  "http://192.168.1.5:8080/"
    private val BASE_URL_4 =  "http://localhost:8080/"

var  httpCLientObj = OkHttpClient.Builder().addInterceptor(object :Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()?.newBuilder()
                ?.addHeader("Accept", "Application/JSON")!!.build()
        return chain!!.proceed(request)    }
})



    public fun getRetrofitInstance(): Retrofit {
          var  retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                  .addCallAdapterFactory(object : RxJavaCallAdapterFactory1()
                  {

                  }) // this line is important
                  .addConverterFactory(GsonConverterFactory.create())
                  .client(httpCLientObj.build())
                  .build()

        //     .addConverterFactory(RXjava3CallAdapterfactory.create())
   // Observable  as ReturnType

        //     .addConverterFactory(ScalarsConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())

        return retrofit
    }
}

private fun Retrofit.Builder.addCallAdapterFactory(rxJavaCallAdapterFactory: RxJavaCallAdapterFactory1): Retrofit.Builder? {
    {
    }


}
}



