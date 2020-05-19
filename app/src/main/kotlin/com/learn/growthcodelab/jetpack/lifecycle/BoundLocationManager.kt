package com.learn.growthcodelab.jetpack.lifecycle

import android.content.Context
import android.location.LocationListener
import android.location.LocationManager
import androidx.lifecycle.LifecycleObserver

class BoundLocationManager {

    class BoundLocationObserver(
            context: Context,
            private val locationListener: LocationListener
    ) : LifecycleObserver {
        private val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager


        fun addLocationListener() {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0.0F , locationListener)
        }
    }


}