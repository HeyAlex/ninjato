[extension-rxjava](../../index.md) / [com.agoda.ninjato.extension.rxjava](../index.md) / [com.agoda.ninjato.Api](index.md) / [single](./single.md)

# single

`inline fun <reified T> Api.single(crossinline receiver: Wrapper<`[`T`](single.md#T)`>.() -> `[`T`](single.md#T)`): Single<`[`T`](single.md#T)`>`

Wraps the network call with [Single](#). If no exceptions were thrown, the inferred return type will be
passed to the subscription.

### Parameters

`receiver` - tail lambda with the actual API call invocation.