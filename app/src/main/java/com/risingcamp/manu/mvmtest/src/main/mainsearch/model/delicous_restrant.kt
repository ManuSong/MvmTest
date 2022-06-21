package com.risingcamp.manu.networkapp.retrofitdata

data class delicous_restrant(
    val currentCount: Int,
    val `data`: List<Data>,
    val matchCount: Int,
    val page: Int,
    val perPage: Int,
    val totalCount: Int
)