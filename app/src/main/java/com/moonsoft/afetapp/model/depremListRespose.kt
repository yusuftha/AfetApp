package com.moonsoft.afetapp.model

import com.google.gson.annotations.SerializedName

data class depremListRespose(
    @SerializedName("result")
    var result: List<Result>,
    @SerializedName("status")
    var status: Boolean
) {
    data class Result(
        @SerializedName("coordinates")
        var coordinates: List<Double>,
        @SerializedName("date")
        var date: String,
        @SerializedName("date_stamp")
        var dateStamp: String,
        @SerializedName("depth")
        var depth: Double,
        @SerializedName("hash")
        var hash: String,
        @SerializedName("hash2")
        var hash2: String,
        @SerializedName("lat")
        var lat: Double,
        @SerializedName("lng")
        var lng: Double,
        @SerializedName("lokasyon")
        var lokasyon: String,
        @SerializedName("mag")
        var mag: Double,
        @SerializedName("rev")
        var rev: Any?,
        @SerializedName("timestamp")
        var timestamp: Int,
        @SerializedName("title")
        var title: String
    )
}