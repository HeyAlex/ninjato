package com.agoda.ninjato.converter

import com.agoda.ninjato.exception.NinjatoException
import com.agoda.ninjato.http.Body
import com.agoda.ninjato.http.Request
import com.agoda.ninjato.reflect.TypeReference.Companion.reifiedType
import java.lang.reflect.Type
import kotlin.reflect.KProperty

interface BodyConverter<in I, out O> {
    fun convert(instance: I): O

    interface Factory {
        fun requestConverter(type: Type): BodyConverter<*, Body>?
        fun responseConverter(type: Type): BodyConverter<Body, *>?
    }

    @Suppress("UNCHECKED_CAST")
    class Delegate(val factories: ConverterFactories) {
        var body: Body? = null

        operator fun getValue(thisRef: Request.Configurator.WithBody, property: KProperty<*>) = body

        inline operator fun <reified T> setValue(thisRef: Request.Configurator.WithBody, property: KProperty<*>, value: T) {
            body = when (value) {
                is String -> Body(value)
                is ByteArray -> Body(value.toString())
                else -> {
                    var converter: BodyConverter<T, Body>? = null

                    factories.resolve().firstOrNull {
                        converter = it.requestConverter(reifiedType<T>()) as? BodyConverter<T, Body>
                        converter != null
                    }?.let {
                        converter!!.convert(value)
                    } ?: throw NinjatoException(
                            thisRef.fullUrl ?: thisRef.endpointUrl,
                            UnsupportedOperationException(
                                    "Couldn't convert provided body. Did you registered " +
                                            "BodyConverter.Factory that provides serializer for ${T::class.java.simpleName} type?"
                            )
                    )
                }
            }
        }
    }
}