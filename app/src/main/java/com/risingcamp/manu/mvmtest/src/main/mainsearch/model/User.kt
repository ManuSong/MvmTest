package com.risingcamp.manu.networkapp.retrofitdata

import android.os.Parcel
import android.os.Parcelable
import com.kakao.sdk.user.model.Account
import java.util.*


data class User(val id: Long?, val properties: Map<String, String>?, val kakaoAccount: Account?, val groupUserToken: String?, val connectedAt: Date?, val synchedAt: Date?, val hasSignedUp: Boolean?) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Long::class.java.classLoader) as? Long,
        TODO("properties"),
        parcel.readParcelable(Account::class.java.classLoader),
        parcel.readString(),
        TODO("connectedAt"),
        TODO("synchedAt"),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeParcelable(kakaoAccount, flags)
        parcel.writeString(groupUserToken)
        parcel.writeValue(hasSignedUp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
