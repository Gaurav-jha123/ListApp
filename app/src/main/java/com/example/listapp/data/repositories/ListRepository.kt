package com.example.listapp.data.repositories

import com.example.listapp.data.db.ListDatabase
import com.example.listapp.data.db.entities.ListItem

class ListRepository(
    private val db: ListDatabase
) {
    suspend fun upsert(item: ListItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ListItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}