package com.example.forecastmvvm.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import com.example.forecastmvvm.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptorImpl(
    context: Context
) : ConnectivityInterceptor {

    private val appContext = context.applicationContext  //So when some fragment or activity is destroyed the app context keeps intact because referencing the whole app

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline())
            throw NoConnectivityException()
        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean {
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager
        var network: Network = connectivityManager.activeNetwork
        var networkCapabilities: NetworkCapabilities = connectivityManager.getNetworkCapabilities(network)
            ?: return false  //Elvis operator to check if it is null
        return true
    }

}