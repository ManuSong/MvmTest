package com.risingcamp.manu.mvmtest.src.main.mainsearch.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.rxjava2.flowable
import com.risingcamp.manu.mvmtest.src.main.mainsearch.MainSearchRetrofitInterface
import com.risingcamp.manu.networkapp.retrofitdata.Data
import kotlinx.coroutines.flow.Flow

class PagingRepositoryImpl(
    private val service: MainSearchRetrofitInterface
)  : PagingRepository {
    override fun getDataList(): Flow<PagingData<Data>> {
        return 1
    }
}