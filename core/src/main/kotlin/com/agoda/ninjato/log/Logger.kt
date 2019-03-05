package com.agoda.ninjato.log

/**
 * Simple logger interface.
 * There is no default implementation provided with the core module.
 */
interface Logger {
    fun log(level: Level, message: String)
    fun log(level: Level, message: String, throwable: Throwable)
}