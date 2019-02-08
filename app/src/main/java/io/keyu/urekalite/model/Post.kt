package io.keyu.urekalite.model

import com.squareup.moshi.Json
import java.util.Date

data class Post(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    val link: String?,
    val text: String,
    val liked: Boolean,
    val bookmarked: Boolean,
    val creationDate: Date,
    val media: List<String>,
    val user: User,
    @Json(name = "url") val photo: String?
)