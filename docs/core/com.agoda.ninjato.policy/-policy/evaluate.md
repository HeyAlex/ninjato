[core](../../index.md) / [com.agoda.ninjato.policy](../index.md) / [Policy](index.md) / [evaluate](./evaluate.md)

# evaluate

`abstract fun evaluate(request: `[`Request`](../../com.agoda.ninjato.http/-request/index.md)`, throwable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`T`](index.md#T)

Evaluation of the policy. Based on the type, should return different types of resolution.

### Parameters

`request` - request instance that has failed executing.

`throwable` - error that occurred during request execution.

**Return**
policy's resolution.

