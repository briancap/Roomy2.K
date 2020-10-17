package com.example.roomy2k

import android.app.Application
import timber.log.Timber

class RoomyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant( Timber.DebugTree() )

    }
}