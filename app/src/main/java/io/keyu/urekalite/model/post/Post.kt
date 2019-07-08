package io.keyu.urekalite.model.post

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import com.squareup.moshi.Json
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Entity(
    tableName = "posts",
    indices = [
        Index("localId")
    ]
)
@Parcelize
data class Post(
    @Embedded
    @field:Json(name = "post")
    val content: Content,

    @Ignore
    @field:Json(name = "actionCount")
    val actionCount: ActionCount,

    @Ignore
    @field:Json(name = "tags")
    val tags: List<Tag>,

    @Ignore
    @field:Json(name = "liked")
    val liked: Boolean,

    @Ignore
    @field:Json(name = "bookmarked")
    val bookmarked: Boolean,

    @Ignore
    @field:Json(name = "commented")
    val commented: Boolean,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "localId")
    var id: Long = 0
) : Parcelable {
    // in order to be consistent with the backend if backend changes the order
    @IgnoredOnParcel var indexInResponse: Int = -1
}
