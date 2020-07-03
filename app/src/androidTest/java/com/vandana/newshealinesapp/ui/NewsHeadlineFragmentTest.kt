package com.vandana.newshealinesapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.vandana.newshealinesapp.R
import com.vandana.newshealinesapp.ui.main.MainActivity
import com.vandana.newshealinesapp.ui.newsHealinesFragment.NewsHeadlineAdapter
import com.vandana.newshealinesapp.ui.newsHealinesFragment.NewsHeadlineFragment
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

class NewsHeadlineFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isListFragmentVisible_onAppLaunch() {

        onView(withId(R.id.rvHeadlinesList))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rvHeadlinesList))
            .perform(scrollToPosition<NewsHeadlineAdapter.ViewHolder>(3))
    }



    @Test
    fun postsAvailable_shouldDisplay() {

        launchFragmentInContainer<NewsHeadlineFragment>(Bundle(), R.style.AppTheme)

        onView(withId(R.id.rvHeadlinesList)).check(matches(isDisplayed()))
        onView(withId(R.id.rvHeadlinesList))
            .perform(scrollToPosition<NewsHeadlineAdapter.ViewHolder>(0))
            .check(
                matches(
                    atPositionOnView(
                        0,
                        ViewMatchers.withText("Headline1"),
                        R.id.tvTitleName
                    )
                )
            )


        onView(withId(R.id.rvHeadlinesList))
            .perform(scrollToPosition<NewsHeadlineAdapter.ViewHolder>(1))
            .check(
                matches(
                    atPositionOnView(
                        1,
                        ViewMatchers.withText("Headline2"),
                        R.id.tvTitleName
                    )
                )
            )
    }


    private fun atPositionOnView(
        position: Int, itemMatcher: Matcher<View>,
        targetViewId: Int
    ): Matcher<View> {

        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has view id $itemMatcher at position $position")
            }

            public override fun matchesSafely(recyclerView: RecyclerView): Boolean {
                val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
                val targetView = viewHolder!!.itemView.findViewById<View>(targetViewId)
                return itemMatcher.matches(targetView)
            }
        }
    }



}