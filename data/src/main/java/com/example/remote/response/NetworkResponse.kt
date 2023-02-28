package com.example.remote.response

import java.io.IOException

sealed class NetworkResponse<out T : Any, out U : Any> {


     /**
        loading response
     **/

    object Loading : NetworkResponse<Nothing, Nothing>()


    //   data class Loading<T : Any>(val body: T) : com.example.remote.response.NetworkResponse<T, Nothing>()
    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ApiError<U : Any>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()

    /**
     * Network error
     */
    data class NetworkError(val error: IOException) : NetworkResponse<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()
}
