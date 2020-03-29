package net.gotev.swapi.helpers

import okhttp3.Interceptor

internal class UserAgentInterceptor(private val userAgent: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain) =
        chain.proceed(
            chain.request().newBuilder()
                .header("User-Agent", userAgent)
                .build()
        )
}
