package io.keyu.urekalite.model.post

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tag(
    @Json(name = "id") val id: Int,
    @Json(name = "tagName") val tagName: String
) : Parcelable
