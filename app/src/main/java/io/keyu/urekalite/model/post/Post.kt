package io.keyu.urekalite.model.post

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Post(
    @field:Json(name = "post") val content: @RawValue Content,
    @field:Json(name = "actionCount") val actionCount: @RawValue ActionCount,
    @field:Json(name = "tags") val tags: @RawValue List<Tag>,
    @field:Json(name = "liked") val liked: Boolean,
    @field:Json(name = "bookmarked") val bookmarked: Boolean,
    @field:Json(name = "commented") val commented: Boolean
) : Parcelable