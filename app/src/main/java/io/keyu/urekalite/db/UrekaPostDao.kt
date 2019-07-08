package io.keyu.urekalite.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.keyu.urekalite.model.post.Post

@Dao
interface UrekaPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts : List<Post>)


    @Query("SELECT * FROM posts ORDER BY indexInResponse ASC")
    fun posts() : DataSource.Factory<Int, Post>

    @Query("SELECT MAX(indexInResponse) + 1 FROM posts")
    fun getNextIndexInPosts() : Int
}
