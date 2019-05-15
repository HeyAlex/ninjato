package com.agoda.ninjato.http

import com.agoda.ninjato.dsl.Commons
import com.agoda.ninjato.intercept.Interceptors
import com.agoda.ninjato.policy.FallbackPolicy
import com.agoda.ninjato.policy.RetryPolicy
import com.agoda.ninjato.converter.ConverterFactories
import com.agoda.ninjato.misc.toUrlEncoded
import java.lang.StringBuilder

/**
 * Base http entity of the library.
 * Translates into the actual http request by [HttpClient].
 */
open class Request {
    lateinit var method: Method

    var baseUrl: String = ""
    var endpointUrl: String = ""
    var fullUrl: String = ""

    /**
     * Represents the actual URL that the server needs to hit.
     * If [fullUrl] property is provided, than this property will return value of [fullUrl]
     * or else will return concatenation of [baseUrl] (provided by [api][com.agoda.ninjato.Api]) and
     * [endpointUrl].
     */
    val url: String
        get() = StringBuilder().apply {
            append(if (fullUrl.isNotBlank()) fullUrl else baseUrl + endpointUrl)
            append(parameters.toUrlEncoded(!contains('?'), contains('?')))
        }.toString()

    val headers: MutableMap<String, MutableList<String>> = mutableMapOf()
    val parameters: MutableMap<String, String> = LinkedHashMap()

    var body: Body? = null

    var retries = 0

    /**
     * Factory class for creating instances of request.
     * In case you need to extend [Request] and enrich it with some data of your own,
     * provide instance of factory to [HttpClient].
     */
    abstract class Factory {
        abstract fun create(): Request
    }

    /**
     * DSL context for configuring the [Request].
     */
    open class Configurator : Commons {
        final override val headers = Headers()
        final override val parameters = Parameters()
        final override val interceptors = Interceptors()
        final override val converterFactories = ConverterFactories()

        final override var retryPolicy: RetryPolicy? = null
        final override var fallbackPolicy: FallbackPolicy? = null

        var endpointUrl: String? = null
        var fullUrl: String? = null

        @PublishedApi
        internal open fun configure(instance: Request) = instance.also {
            it.endpointUrl = endpointUrl ?: ""
            it.fullUrl = fullUrl ?: ""
            it.headers.putAll(headers.resolve())
            it.parameters.putAll(parameters.resolve())
        }

        /**
         * DSL context for configuring the [Request] with [Body]
         */
        open class WithBody : Configurator() {
            var body: Any? by Body.Delegate(converterFactories)
            override fun configure(instance: Request) = super.configure(instance).also { it.body = body as Body? }
        }
    }
}
