[ninjato-core](../../index.md) / [com.agoda.ninjato.exception](../index.md) / [HttpException](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`HttpException(request: `[`Request`](../../com.agoda.ninjato.http/-request/index.md)`, response: `[`Response`](../../com.agoda.ninjato.http/-response/index.md)`)`

This exception is thrown when [request](../../com.agoda.ninjato.http/-request/index.md) returns error code and the
inferred (request) return type is not [response](../../com.agoda.ninjato.http/-response/index.md).

Library throws this exception because in case you are requesting not a raw body, any error returned
by server means that response contains [body](../../com.agoda.ninjato.http/-body/index.md) that is already incompatible
with the expected type or not awaited by the user.

### Parameters

`request` - request that has been executed

`response` - response that server has returned