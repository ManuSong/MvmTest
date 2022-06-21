package com.risingcamp.manu.mvmtest.src.main.mainsearch

import com.risingcamp.manu.networkapp.retrofitdata.ResReviewData
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant

interface MainSearchFragmentInterface {

   fun onGetRestaurantSuccess(response : delicous_restrant)

   fun onGetRestaurantFail(message : String)

   fun onGetReviewSuccess(response : ResReviewData)

   fun onGetReviewFail(message: String)

}