package com.dicoding.latihan.moviecatalog.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.latihan.moviecatalog.R
import com.dicoding.latihan.moviecatalog.utils.DataDummy
import com.dicoding.latihan.moviecatalog.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvshow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingTestResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingTestResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movie_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.txt_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_desc)).check(matches(withText(dummyMovies[0].description)))
        onView(withId(R.id.fav_detail)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(dummyTvShows[0].title)))
        onView(withId(R.id.txt_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_desc)).check(matches(withText(dummyTvShows[0].description)))
        onView(withId(R.id.fav_detail)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }


    @Test
    fun loadFavoriteList() {
        onView(withId(R.id.fav_destinasi)).perform(click())
        onView(withId(R.id.fav_movie_rv)).check(matches(isDisplayed()))
        onView(withId(R.id.fav_movie_rv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fav_detail)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText(R.string.tv_show)).perform(click())
        onView(withId(R.id.fav_tvshow_rv)).check(matches(isDisplayed()))
        onView(withId(R.id.fav_tvshow_rv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fav_detail)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

}