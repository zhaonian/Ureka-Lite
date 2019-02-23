package io.keyu.urekalite.model

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "status") var status: Int,
    @field:Json(name = "error") var error: String
)