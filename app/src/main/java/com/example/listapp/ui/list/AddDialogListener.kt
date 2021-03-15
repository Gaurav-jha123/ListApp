package com.example.listapp.ui.list

import com.example.listapp.data.db.entities.ListItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ListItem)
}