package com.risingcamp.manu.mvmtest.src.main.mainsearch.model

import androidx.paging.PagingData
import com.risingcamp.manu.networkapp.retrofitdata.Data
import kotlinx.coroutines.flow.Flow

interface PagingRepository {

    fun getDataList() : Flow<PagingData<Data>>
}