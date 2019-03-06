package io.keyu.urekalite.model.post

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActionCount(
    @field:Json(name = "Comment") val comment: Long,
    @field:Json(name = "Like") val like: Long,
    @field:Json(name = "Share") val share: Long,
    @field:Json(name = "Bookmark") val bookmark: Long
) : Parcelable