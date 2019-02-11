package io.keyu.urekalite.model

import com.squareup.moshi.Json

data class Post(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    val link: String?,
    val text: String?,
    val liked: Boolean,
    val bookmarked: Boolean,
    val media: List<String>?,
    val user: User?,
    @Json(name = "url") val photo: String?
)