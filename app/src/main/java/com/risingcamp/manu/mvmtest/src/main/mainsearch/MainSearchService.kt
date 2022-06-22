package com.risingcamp.manu.mvmtest.src.main.mainsearch

import android.app.Application
import android.util.Log
import com.risingcamp.manu.mvmtest.BuildConfig
import com.risingcamp.manu.mvmtest.R
import com.risingcamp.manu.mvmtest.config.ApplicationClass
import com.risingcamp.manu.networkapp.retrofitdata.ResReviewData
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class MainSearchService(val mainSearchFragmentInterface: MainSearchFragmentInterface) {

    fun getRestaurant(){
        val mainSearchRetrofitInterface = ApplicationClass.sRetrofit.create(MainSearchRetrofitInterface::class.java)
        mainSearchRetrofitInterface.getRestaurant(1,61, BuildConfig.API_KEY).
        enqueue(object : Callback<delicous_restrant> {
            override fun onResponse(
                call: Call<delicous_restrant>,
                response: Response<delicous_restrant>
            ) {
                if (response.isSuccessful){
                    mainSearchFragmentInterface.onGetRestaurantSuccess(response.body() as delicous_restrant)
                }

            }

            override fun onFailure(call: Call<delicous_restrant>, t: Throwable) {
                mainSearchFragmentInterface.onGetRestaurantFail(t.message ?: "통신 오류")
            }

        })
    }

    fun getReview() {
        val mainSearchRetrofitInterface = ApplicationClass.sRetrofit.create(MainSearchRetrofitInterface::class.java)
        mainSearchRetrofitInterface.getResImgName(1, 61, BuildConfig.API_KEY)
            .enqueue(object : Callback<ResReviewData>{
                override fun onResponse(
                    call: Call<ResReviewData>,
                    response: Response<ResReviewData>
                ) {
                    if (response.isSuccessful){
                        mainSearchFragmentInterface.onGetReviewSuccess(response.body() as ResReviewData)
                    }

                }

                override fun onFailure(call: Call<ResReviewData>, t: Throwable) {
                    mainSearchFragmentInterface.onGetRestaurantFail(t.message ?: "통신 오류")
                }

            })
    }
}