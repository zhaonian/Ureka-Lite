package io.keyu.urekalite.model.post

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Content(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "urekaId") val urekaId: String?,

    @field:Json(name = "channelId") val channelId: Long?,
    @field:Json(name = "channelTitle") val channelTitle: String?,

    @field:Json(name = "userId") val postOwnerId: Long?,
    @field:Json(name = "userName") val postOwnerUserName: String,
    @field:Json(name = "userDisplayedName") val postOwnerDisplayedName: String,
    @field:Json(name = "userAvatar") val postOwnerAvatar: String,

    @field:Json(name = "title") val title: String,
    @field:Json(name = "link") val link: String,
    @field:Json(name = "text") val text: String,
    @field:Json(name = "smallMediaPaths") val smallMediaPaths: List<String>?,

    @field:Json(name = "role") val role: String,

    @field:Json(name = "channelGroupGroup") val branch: Branch?,
    @field:Json(name = "channelGroup") val channelGroup: ChannelGroup?
) : Parcelable

@Parcelize
data class Branch(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "groupGroupName") val groupGroupName: String,
    @field:Json(name = "groupGroupNameAbbr") val groupGroupNameAbbr: String,
    @field:Json(name = "channelGroups") val channelGroups: List<ChannelGroup>?
) : Parcelable

@Parcelize
data class ChannelGroup(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "groupName") val groupName: String,
    @field:Json(name = "groupNameAbbr") val groupNameAbbr: String
) : Parcelable