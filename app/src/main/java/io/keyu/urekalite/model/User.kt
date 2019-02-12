package io.keyu.urekalite.model

data class User(
    var id: Long,
    var username: String,
    var displayName: String,
    var avatar: String?,
    var role: String,
    var orcidVerified: Boolean,
    var bio: String?
)