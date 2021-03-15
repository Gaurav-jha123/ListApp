package com.example.listapp.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapp.R
import com.example.listapp.data.db.entities.ListItem
import com.example.listapp.other.ListItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ListActivity: AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ListViewModelFactory by instance()

    lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)

        val adapter = ListItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddListItemDialog(
                this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ListItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }

}