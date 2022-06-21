package com.risingcamp.manu.networkapp.retrofitdata

import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("메뉴(ID)") val menu: Int,
    @SerializedName("식당(ID)")  val resId: Int,
    @SerializedName("식당명") val resName: String,
    @SerializedName("음식이미지(ID)") val foodImageId: Int,
    @SerializedName("음식이미지(URL)") val foodImgUrl: String,
    @SerializedName("지역명")val localPlace : String
) {
    constructor(resName: String, foodImgUrl: String, localPlace: String) : this(0,0, resName, 0, foodImgUrl, localPlace)
}