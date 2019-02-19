package io.keyu.urekalite.model.post

import com.squareup.moshi.Json

data class Tag(
    @Json(name = "id") val id: Int,
    @Json(name = "tagName") val tagName: String
)
