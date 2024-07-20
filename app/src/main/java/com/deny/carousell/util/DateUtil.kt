package com.deny.carousell.util

import android.content.Context
import com.deny.carousell.R

object DateUtil {

    fun formatTime(context: Context, timeCreated: Int): String {
        val currentUnixTime = System.currentTimeMillis() / 1000
        val elapsedTime = currentUnixTime - timeCreated

        return when {
            elapsedTime < SECONDS_IN_MINUTE -> context.getString(R.string.time_format_just_now)
            elapsedTime < SECONDS_IN_HOUR -> context.getString(R.string.time_format_minutes_ago, elapsedTime.toMinutes())
            elapsedTime < SECONDS_IN_DAY -> context.getString(R.string.time_format_hours_ago, elapsedTime.toHours())
            elapsedTime < SECONDS_IN_WEEK -> context.getString(R.string.time_format_days_ago, elapsedTime.toDays())
            elapsedTime < SECONDS_IN_MONTH -> context.getString(R.string.time_format_weeks_ago, elapsedTime.toWeeks())
            elapsedTime < SECONDS_IN_YEAR -> context.getString(R.string.time_format_months_ago, elapsedTime.toMonths())
            else -> context.getString(R.string.time_format_years_ago, elapsedTime.toYears())
        }
    }

    private const val SECONDS_IN_MINUTE = 60
    private const val SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTE
    private const val SECONDS_IN_DAY = 24 * SECONDS_IN_HOUR
    private const val SECONDS_IN_WEEK = 7 * SECONDS_IN_DAY
    private const val SECONDS_IN_MONTH = 30 * SECONDS_IN_DAY
    private const val SECONDS_IN_YEAR = 365 * SECONDS_IN_DAY
    private fun Long.toMinutes(): Long = this / SECONDS_IN_MINUTE
    private fun Long.toHours(): Long = this / SECONDS_IN_HOUR
    private fun Long.toDays(): Long = this / SECONDS_IN_DAY
    private fun Long.toWeeks(): Long = this / SECONDS_IN_WEEK
    private fun Long.toMonths(): Long = this / SECONDS_IN_MONTH
    private fun Long.toYears(): Long = this / SECONDS_IN_YEAR


}