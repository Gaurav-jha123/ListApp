package com.example.listapp.ui.list

import androidx.lifecycle.ViewModel
import com.example.listapp.data.db.entities.ListItem
import com.example.listapp.data.repositories.ListRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: ListRepository
) : ViewModel() {

    fun upsert(item: ListItem) =
        GlobalScope.launch {
            repository.upsert(item)
        }

    fun delete(item: ListItem) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()

}
