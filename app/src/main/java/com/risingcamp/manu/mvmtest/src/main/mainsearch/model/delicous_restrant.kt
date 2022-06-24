package com.risingcamp.manu.networkapp.retrofitdata

import com.google.gson.annotations.SerializedName

data class delicous_restrant(
    val currentCount: Int,
    val `data`: List<Data>,
    val matchCount: Int,
    val page: Int,
    val perPage: Int,
    @SerializedName("totalCount") val totalCount: Int
)