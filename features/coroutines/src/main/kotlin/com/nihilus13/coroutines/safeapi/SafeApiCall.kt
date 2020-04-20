package com.nihilus13.coroutines.safeapi

inline fun <T> safeApiCall(responseFunction: () -> T): SafeApiResponse<T> {
    var wrappedResponse: SafeApiResponse<T>
    try {
        val response = responseFunction()
        wrappedResponse = SafeApiResponse.Success(response)
    } catch (e: Exception) {
        e.printStackTrace()
        wrappedResponse = SafeApiResponse.Failure(e)
    }
    return wrappedResponse
}