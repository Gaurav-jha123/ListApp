package com.example.listapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listapp.data.repositories.ListRepository


@Suppress("UNCHECKED_CAST")
class ListViewModelFactory (
    private val repository: ListRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}