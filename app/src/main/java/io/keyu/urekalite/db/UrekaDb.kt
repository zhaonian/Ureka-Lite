package io.keyu.urekalite.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.keyu.urekalite.model.User
import io.keyu.urekalite.model.post.Post

/** Database schema for Ureka. */
@Database(
    entities = [User::class, Post::class],
    version = 1,
    exportSchema = true
)
abstract class UrekaDb: RoomDatabase() {
    companion object {
        fun create(context: Context, useInMemory : Boolean): UrekaDb {
            val databaseBuilder = if(useInMemory) {
                Room.inMemoryDatabaseBuilder(context, UrekaDb::class.java)
            } else {
                Room.databaseBuilder(context, UrekaDb::class.java, "ureka.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun postDao(): UrekaPostDao
}
