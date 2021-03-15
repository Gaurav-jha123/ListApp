package com.example.listapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.listapp.data.db.entities.ListItem

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ListItem)

    @Delete
    suspend fun delete(item: ListItem)

    @Query("SELECT * FROM list_items")
    fun getAllShoppingItems(): LiveData<List<ListItem>>
}