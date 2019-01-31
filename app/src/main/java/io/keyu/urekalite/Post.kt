package io.keyu.urekalite

import java.util.Date

data class Post(
    var id: Long,
    var title: String,
    var link: String,
    var text: String,
    var liked: Boolean,
    var bookmarked: Boolean,
    var creationDate: Date,
    var media: List<String>,
    var user: User
)