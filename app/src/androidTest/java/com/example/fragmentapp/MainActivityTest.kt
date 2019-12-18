package com.example.fragmentapp


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun test_activity() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main))
            .check(matches(isDisplayed())) //method 1
    }

    @Test
    fun test_container_a() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.container_a))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE))) //method 2
    }

    @Test
    fun test_container_b() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.container_b))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE))) //method 2
    }

}