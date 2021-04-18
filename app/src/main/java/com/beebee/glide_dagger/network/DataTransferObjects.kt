package com.beebee.glide_dagger.network

import com.beebee.glide_dagger.domain.Image
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkImage(
    val id: String,

    @Json(name = "download_url")
    val url: String
)

fun List<NetworkImage>.asDomainModel() : List<Image> {
    return map {
        Image(
            it.id,
            it.url
        )
    }
}