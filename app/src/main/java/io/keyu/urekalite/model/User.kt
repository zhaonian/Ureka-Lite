package io.keyu.urekalite.model

import com.squareup.moshi.Json

data class User(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "username") val username: String,
    var displayName: String,
    @field:Json(name = "avatar") val avatar: String?,
    @field:Json(name = "role") val role: String,
    var orcidVerified: Boolean,
    var bio: String?,
    @field:Json(name = "token") val authToken: String
)

data class UserLoginRequest(
    val email: String,
    val password: String
)