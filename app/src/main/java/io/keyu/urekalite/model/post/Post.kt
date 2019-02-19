package io.keyu.urekalite.model.post

import com.squareup.moshi.Json

data class Post(
    @field:Json(name = "post") val content: Content,
    @field:Json(name = "actionCount") val actionCount: ActionCount,
    @field:Json(name = "tags") val tags: List<Tag>,
    @field:Json(name = "liked") val liked: Boolean,
    @field:Json(name = "bookmarked") val bookmarked: Boolean,
    @field:Json(name = "commented") val commented: Boolean
)