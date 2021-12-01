package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat


import org.junit.Test

class StatisticsUtilsTest{

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // GIVEN: A list of tasks is created
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // WHEN: The getActiveAndCompletedStats function is called with the list of tasks
        val result = getActiveAndCompletedStats(tasks)

        // THEN: Check the result matches the below values
        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }


    @Test
    fun getActiveAndCompletedStats_both_returnsHundredZero() {

        // GIVEN: A list of tasks is created
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        // WHEN: The getActiveAndCompletedStats function is called with the list of tasks
        val result = getActiveAndCompletedStats(tasks)

        // THEN: Check the result matches the below values
        assertThat(result.completedTasksPercent, `is` (40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsHundredZero() {

        // GIVEN: A list of tasks is created
        val tasks = emptyList<Task>()

        // WHEN: The getActiveAndCompletedStats function is called with the list of tasks
        val result = getActiveAndCompletedStats(tasks)

        // THEN: Check the result matches the below values
        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsHundredZero() {

        // GIVEN: A list of tasks is created
        val tasks = null

        // WHEN: The getActiveAndCompletedStats function is called with the list of tasks
        val result = getActiveAndCompletedStats(tasks)

        // THEN: Check the result matches the below values
        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }


}