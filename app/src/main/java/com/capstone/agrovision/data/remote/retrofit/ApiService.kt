package com.capstone.agrovision.data.remote.retrofit

import com.capstone.agrovision.BuildConfig.API_KEY_NEWS
import com.capstone.agrovision.data.remote.response.AgroResponse
import com.capstone.agrovision.data.remote.response.NewsResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Headers("Authorization: Bearer $API_KEY_NEWS")
    @GET("top-headlines?country=id&category=health")
    suspend fun getNews(
        @Query("q") q: String
    ): NewsResponse

    @Multipart
    @POST("predict")
    fun uploadImage(
        @Part file: MultipartBody.Part,
    ): Call<AgroResponse>
}