package com.risingcamp.manu.mvmtest.src.main.mainsearch.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.risingcamp.manu.mvmtest.BuildConfig
import com.risingcamp.manu.mvmtest.src.main.mainsearch.MainSearchRetrofitInterface
import com.risingcamp.manu.networkapp.retrofitdata.Data
import retrofit2.HttpException
import retrofit2.awaitResponse
import java.io.IOException
import java.lang.Exception

class TestPagingSource(
    val service : MainSearchRetrofitInterface
) : PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let {anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val pageIndex = params.key ?: 1
            val response =
                service.getRestaurant(
                    pageIndex,10,BuildConfig.API_KEY
                ).awaitResponse().body()


            val nextKey  = if (response?.data!!.isEmpty()) {
                null
            } else {
                pageIndex + 1
            }
            LoadResult.Page(data = response.data, prevKey = null, nextKey = nextKey)
        } catch (e : IOException){
            return LoadResult.Error(e)
        } catch (e : HttpException){
            return LoadResult.Error(e)
        }
    }
}