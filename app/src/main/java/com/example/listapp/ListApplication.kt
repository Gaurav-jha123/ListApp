package com.example.listapp

import android.app.Application
import com.example.listapp.data.db.ListDatabase
import com.example.listapp.data.repositories.ListRepository
import com.example.listapp.ui.list.ListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ListApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ListApplication))
        bind() from singleton { ListDatabase(instance()) }
        bind() from singleton {
            ListRepository(
                instance()
            )
        }
        bind() from provider {
            ListViewModelFactory(
                instance()
            )
        }
    }
}