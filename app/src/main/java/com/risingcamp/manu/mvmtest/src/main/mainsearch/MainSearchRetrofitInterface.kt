package com.risingcamp.manu.mvmtest.src.main.mainsearch

import com.risingcamp.manu.networkapp.retrofitdata.ResReviewData
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MainSearchRetrofitInterface {

    @GET("15066516/v1/uddi:507e01f5-76ec-42ff-96a5-8b6ff9ce554e")
    fun getRestaurant(
        @Query("page") page : Int,
        @Query("perPage") perPage : Int,
        @Query("serviceKey") serviceKey : String
    ) : Call<delicous_restrant>

    @GET("15097008/v1/uddi:1e5a6f2e-3f79-49bd-819b-d17541e6df78")
    fun getResImgName(
        @Query("page") page : Int,
        @Query("perPage") perPage: Int,
        @Query("serviceKey") serviceKey: String
    ) : Call<ResReviewData>
}