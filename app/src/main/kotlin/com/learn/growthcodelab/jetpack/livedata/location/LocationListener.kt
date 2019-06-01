package com.learn.growthcodelab.jetpack.livedata.location

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class LocationListener(
        private val lifecycleOwner: LifecycleOwner,
        private val callback: (Location) -> Unit
) : DefaultLifecycleObserver{

    private var enabled = false

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        if(enabled) {
            //start to connect
        }
    }

    fun enable() {
        if(lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            enabled = true
            // connect if not connected
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        // disconnect if connected
    }
}