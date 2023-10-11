package com.gls.parcelshop.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateTimeUtil {
    const val DATE_FORMAT_PATTERN = "yyyyMMdd"

    fun getFormattedDate(date: String) =
        runCatching {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))
        }.onFailure { ApplicationLogger.error(message = "Could not parse date", throwable = it) }
}