package com.example.listapp.data.db

import android.content.Context
import com.example.listapp.data.db.entities.ListItem
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ListItem::class],
    version = 1
)
abstract class ListDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ListDao

    companion object {
        @Volatile
        private var instance: ListDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ListDatabase::class.java, "ShoppingDB.db").build()
    }
}