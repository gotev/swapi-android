package net.gotev.swapi.helpers

import okhttp3.CacheControl
import okhttp3.Interceptor
import java.util.concurrent.TimeUnit

/**
 * Rewrites Cache-Control responses to maximize client-side caching.
 *
 * This is dangerous, as it's a server-side or CDN stuff, but when it lacks and there's no
 * control over it, this is an option to reduce network calls and server loads.
 */
internal class CacheMaxAgeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain) =
        chain.proceed(
            chain.request().newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .cacheControl(CacheControl.Builder().maxAge(1, TimeUnit.DAYS).build())
                .build()
        )
}
