[extension-rxjava2](../../index.md) / [com.agoda.ninjato.extension.rxjava2](../index.md) / [com.agoda.ninjato.Api](./index.md)

### Extensions for com.agoda.ninjato.Api

| Name | Summary |
|---|---|
| [completable](completable.md) | `fun Api.completable(receiver: Api.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): Completable`<br>Wraps the network call with [Completable](#). If no exceptions were thrown, [complete()](#) will be invoked as soon as the call finishes. |
| [flowable](flowable.md) | `fun <T> Api.flowable(receiver: Api.() -> `[`T`](flowable.md#T)`): Flowable<`[`T`](flowable.md#T)`>`<br>Wraps the network call with [Flowable](#). If no exceptions were thrown, the inferred return type will be passed to the subscription. |
| [observable](observable.md) | `fun <T> Api.observable(receiver: Api.() -> `[`T`](observable.md#T)`): Observable<`[`T`](observable.md#T)`>`<br>Wraps the network call with [Observable](#). If no exceptions were thrown, the inferred return type will be passed to the subscription. |
| [single](single.md) | `fun <T> Api.single(receiver: Api.() -> `[`T`](single.md#T)`): Single<`[`T`](single.md#T)`>`<br>Wraps the network call with [Single](#). If no exceptions were thrown, the inferred return type will be passed to the subscription. |
