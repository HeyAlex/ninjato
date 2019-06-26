[extension-rxjava2](../../index.md) / [com.agoda.ninjato.extension.rxjava2](../index.md) / [com.agoda.ninjato.Api](index.md) / [completable](./completable.md)

# completable

`inline fun Api.completable(crossinline receiver: Api.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Completable`

Wraps the network call with [Completable](#). If no exceptions were thrown, [complete()](#)
will be invoked as soon as the call finishes.

### Parameters

`receiver` - tail lambda with the actual API call invocation.