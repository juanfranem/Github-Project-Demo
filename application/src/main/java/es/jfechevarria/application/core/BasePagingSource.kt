package es.jfechevarria.application.core

import androidx.paging.PagingSource
import androidx.paging.PagingState

abstract class BasePagingSource<T: Any>: PagingSource<Int, T>() {

    abstract suspend fun getItems(params: Int): List<T>

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult.Page<Int, T> {
        val nextPageNumber = params.key ?: 1
        val response = getItems(nextPageNumber)
        val nextPage
         = if (response.isNotEmpty()) {
            nextPageNumber + 1
        } else {
            null
        }
        return LoadResult.Page(
            data = response,
            prevKey = null,
            nextKey = nextPage
        )
    }
}