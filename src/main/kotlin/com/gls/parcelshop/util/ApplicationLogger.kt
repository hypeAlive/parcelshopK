package com.gls.parcelshop.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MDC

object ApplicationLogger {

    private val logger: Logger = LoggerFactory.getLogger(ApplicationLogger::class.java)

    const val LOG_TYPE = "log_type"

    enum class LogType {
        PARCEL_SHOP;
    }

    /**
     * @param fields will be added as separate json fields
     */
    fun info(message: String, fields: Map<String, Any> = mapOf()) =
        log(fields) { logger.info(message) }

    /**
     * @param fields will be added as separate json fields
     */
    fun warn(message: String, fields: Map<String, Any> = mapOf(), throwable: Throwable? = null) =
        log(fields) { logger.warn(message, throwable) }

    /**
     * @param fields will be added as separate json fields
     */
    fun error(message: String, fields: Map<String, Any> = mapOf(), throwable: Throwable? = null) =
        log(fields) { logger.error(message, throwable) }

    private fun log(fields: Map<String, Any> = mapOf(), log: () -> Unit) {
        fields.forEach {
            MDC.put(it.key, it.value.toString())
        }
        log()
        fields.forEach {
            MDC.remove(it.key)
        }
    }
}
