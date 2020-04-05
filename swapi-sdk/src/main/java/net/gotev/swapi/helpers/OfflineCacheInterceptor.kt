package net.gotev.swapi.helpers

import okhttp3.CacheControl
import okhttp3.Interceptor
import java.util.concurrent.TimeUnit

internal class OfflineCacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain) =
        try {
            chain.proceed(chain.request())
        } catch (exc: Throwable) {
            chain.proceed(
                chain.request().newBuilder()
                    .cacheControl(
                        CacheControl.Builder()
                            .onlyIfCached()
                            .maxStale(1, TimeUnit.DAYS)
                            .build()
                    )
                    .build()
            )
        }
}
