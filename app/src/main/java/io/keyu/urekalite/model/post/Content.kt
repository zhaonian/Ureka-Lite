package io.keyu.urekalite.model.post

import com.squareup.moshi.Json

data class Content(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "urekaId") val urekaId: String,

    @field:Json(name = "channelId") val channelId: Long?,
    @field:Json(name = "channelTitle") val channelTitle: String?,

    @field:Json(name = "userId") val userId: Long,
    @field:Json(name = "userName") val userName: String,
    @field:Json(name = "userDisplayedName") val userDisplayedName: String,
    @field:Json(name = "userAvatar") val userAvatar: String,

    @field:Json(name = "title") val title: String,
    @field:Json(name = "link") val link: String,
    @field:Json(name = "text") val text: String,
    @field:Json(name = "smallMediaPaths") val smallMediaPaths: List<String>?,

    @field:Json(name = "role") val role: String,

    @field:Json(name = "channelGroupGroup") val channelGroupGroup: ChannelGroupGroup,
    @field:Json(name = "channelGroup") val channelGroup: ChannelGroup
)

data class ChannelGroupGroup(
    @Json(name = "id") val id: Long,
    @Json(name = "groupGroupName") val groupGroupName: String,
    @Json(name = "groupGroupNameAbbr") val groupGroupNameAbbr: String
)

data class ChannelGroup(
    @Json(name = "id") val id: Long,
    @Json(name = "groupName") val groupName: String,
    @Json(name = "groupNameAbbr") val groupNameAbbr: String
)