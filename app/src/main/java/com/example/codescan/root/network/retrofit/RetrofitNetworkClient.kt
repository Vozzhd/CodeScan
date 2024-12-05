package com.example.codescan.root.network.retrofit

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.codescan.history.domain.impl.GetDataRequest
import com.example.codescan.root.network.NetworkClient
import com.example.codescan.scan.data.network.PostDataRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class RetrofitNetworkClient(
    private val context: Context,
    private val apiService: ApiService
) : NetworkClient {
    override suspend fun doRequest(dto: Any): Response {

        val responseCode = Response()

        if (!connectionCheck()) {
            responseCode.resultCode = -1
        } else if (!typeCheckError(dto)) {
            responseCode.resultCode = 400
        } else {
            withContext(Dispatchers.IO) {
                try {
                    when (dto) {
                        is PostDataRequest -> apiService.postData(dto.data)
                        is GetDataRequest -> apiService.getData()
                    }
                    responseCode.resultCode = 200
                } catch (ioException: IOException) {
                    responseCode.resultCode = 500
                } catch (httpException: HttpException) {
                    responseCode.resultCode = 400
                }

            }
        }
        return responseCode
    }


    private fun connectionCheck(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
            }
        }
        return false
    }

    private fun typeCheckError(dto: Any): Boolean {
        return dto is PostDataRequest
    }
}