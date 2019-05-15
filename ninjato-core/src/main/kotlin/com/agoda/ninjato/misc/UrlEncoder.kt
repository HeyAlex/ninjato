package com.agoda.ninjato.misc

import java.lang.StringBuilder
import java.net.URLEncoder

@PublishedApi
internal fun Map<String, String>.toUrlEncoded(isSeparatorRequired: Boolean = false, isPrefixRequired: Boolean = false)
        = if (isEmpty()) "" else StringBuilder().apply {
    val map = this@toUrlEncoded
    val iterator = map.iterator()

    if (isSeparatorRequired) append('?') else if (isPrefixRequired) append('&')

    do {
        val (key, value) = iterator.next()
        append("$key=${URLEncoder.encode(value, "utf-8")}")
    } while (iterator.hasNext().also { if (it) append('&') })
}.toString()
