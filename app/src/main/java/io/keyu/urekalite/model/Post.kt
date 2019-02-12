package io.keyu.urekalite.model

import com.squareup.moshi.Json

data class Post(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "title") val title: String,
    val link: String?,
    val text: String?,
    val liked: Boolean,
    val bookmarked: Boolean,
    val media: List<String>?,
    val user: User?,
    @field:Json(name = "url") val photo: String
)