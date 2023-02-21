package com.moonsoft.afetapp.service

import com.moonsoft.afetapp.model.depremListRespose
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DepremApiService {
    private val BASE_URL = "https://api.orhanaydogdu.com.tr/deprem/"
    var gson = GsonBuilder()
        .setLenient()
        .create()
    private val api =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DepremApi::class.java)


    fun getDeprem(): Single<depremListRespose> {
        return api.getDeprem()
    }
}