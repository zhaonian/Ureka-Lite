package io.keyu.urekalite.model.response

import com.squareup.moshi.Json
import io.keyu.urekalite.model.post.Branch

data class BranchListReponse(@field:Json(name = "channelGroupGroup") val branchList: List<Branch>)