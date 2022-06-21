package com.risingcamp.manu.networkapp.retrofitdata

data class ResReviewData(
    val currentCount: Int,
    val `data`: List<DataX>,
    val matchCount: Int,
    val page: Int,
    val perPage: Int,
    val totalCount: Int
)