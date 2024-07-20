package com.deny.carousell.util

import java.util.concurrent.TimeUnit

object DateUtil {

    fun formatTime(timeCreated: Int): String {
        val currentTime = System.currentTimeMillis() / 1000
        val timeDifference = currentTime - timeCreated

        val minutes = TimeUnit.SECONDS.toMinutes(timeDifference)
        val hours = TimeUnit.SECONDS.toHours(timeDifference)
        val days = TimeUnit.SECONDS.toDays(timeDifference)
        val weeks = days / 7
        val months = days / 30
        val years = days / 365

        return when {
            timeDifference < 60 -> "just now"
            timeDifference < 3600 -> "$minutes minutes ago"
            timeDifference < 86400 -> "$hours hours ago"
            timeDifference < 604800 -> "$days days ago"
            timeDifference < 2592000 -> "$weeks weeks ago"
            timeDifference < 31536000 -> "$months months ago"
            else -> "$years years ago"
        }
    }
}