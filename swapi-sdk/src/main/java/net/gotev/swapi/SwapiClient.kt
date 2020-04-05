package net.gotev.swapi

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.squareup.moshi.Moshi
import net.gotev.swapi.helpers.CacheMaxAgeInterceptor
import net.gotev.swapi.helpers.Iso8601DateTimeTypeAdapter
import net.gotev.swapi.helpers.OfflineCacheInterceptor
import net.gotev.swapi.helpers.UserAgentInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val moshi by lazy {
    Moshi.Builder()
        .add(Iso8601DateTimeTypeAdapter())
        .build()
}

lateinit var swapiClient: Swapi

fun initializeSwapiClient(
    application: Application,
    httpClient: OkHttpClient = OkHttpClient.Builder()
        .cache(Cache(application.cacheDir, 10 * 1024 * 1024))
        .addInterceptor(OfflineCacheInterceptor())
        .addNetworkInterceptor(CacheMaxAgeInterceptor())
        .addNetworkInterceptor(
            UserAgentInterceptor("swapi-sdk-android/${BuildConfig.VERSION_NAME}")
        ).build()
) {
    AndroidThreeTen.init(application)

    swapiClient = Retrofit.Builder()
        .client(httpClient)
        .baseUrl("https://swapi.co/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(Swapi::class.java)
}
