package com.learn.growthcodelab.navigation

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder
import com.learn.growthcodelab.R

class DeepLinkAppWidgetProvider: AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val remoteViews = RemoteViews(context.packageName, R.layout.app_widget_deep_link)
        val arguments = Bundle()
        arguments.putString(SOURCE_FROM_APP_WIDGET, "from app widget")
        val pendingIntent = NavDeepLinkBuilder(context)
                .setGraph(R.navigation.navigation)
                .setDestination(R.id.destination_deep_link)
                .setArguments(arguments)
                .setComponentName(NavigationActivity::class.java)
                .createPendingIntent()
        remoteViews.setOnClickPendingIntent(R.id.btn_navigation_app_widget, pendingIntent)
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }

    companion object {
        const val SOURCE_FROM_APP_WIDGET = "source_from_app_widget"
    }
}