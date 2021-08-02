package com.dicoding.latihan.moviecatalog.utils

import androidx.paging.PagedList
import org.mockito.Mockito

object PageListUtil {
    fun <T>mockPageList(list: List<T>) : PagedList<T> {
        val pagedList = Mockito.mock(PagedList::class.java) as PagedList<T>
        Mockito.`when`(pagedList[Mockito.anyInt()]).then { invocations ->
            val index = invocations.arguments.first() as Int
            list[index]
        }
        Mockito.`when`(pagedList.size).thenReturn(list.size)

        return pagedList
    }
}