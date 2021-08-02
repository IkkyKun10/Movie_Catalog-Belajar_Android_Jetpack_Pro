package com.dicoding.latihan.moviecatalog.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"
    val idlingTestResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingTestResource.increment()
    }

    fun decrement() {
        idlingTestResource.decrement()
    }

}