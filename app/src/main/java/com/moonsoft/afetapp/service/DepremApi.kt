package com.moonsoft.afetapp.service

import com.moonsoft.afetapp.model.depremListRespose
import io.reactivex.Single
import retrofit2.http.GET

interface DepremApi {

    companion object {
        private const val Deprem = "live.php?limit=50"
    }

    @GET(Deprem)
    fun getDeprem(): Single<depremListRespose>
}