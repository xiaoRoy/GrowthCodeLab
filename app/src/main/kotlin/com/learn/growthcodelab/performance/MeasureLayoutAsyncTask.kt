package com.learn.growthcodelab.performance

import android.os.AsyncTask
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit

private class MeasureLayoutAsyncTask(
        val executingNthIteration: String,
        val btnStartRef: WeakReference<Button>,
        val tvFinishRef: WeakReference<TextView>,
        val containerRef: WeakReference<ViewGroup>
) : AsyncTask<Void?, Int, Void?>() {


    override fun doInBackground(vararg params: Void?): Void? {
        for(index in 0 until TOTAL) {
            publishProgress(index)
            try {
                TimeUnit.MILLISECONDS.sleep(100)
            } catch (ignore: InterruptedException) {
                //no op
            }
        }
        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        val btnStart = btnStartRef.get() ?: return
        btnStart.text = String.format(executingNthIteration, values[0], TOTAL)
        val container = containerRef.get() ?: return
        measureAndLayoutWrapContent(container)
        measureAndLayoutExactlySize(container)
    }

    override fun onPreExecute() {
        val tvFinish = tvFinishRef.get() ?: return
        tvFinish.visibility = View.VISIBLE
        val btnStart = btnStartRef.get() ?: return
        btnStart.visibility = View.GONE
    }

    private fun measureAndLayoutWrapContent(container: ViewGroup) {
        val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(WIDTH, View.MeasureSpec.AT_MOST)
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(HEIGHT, View.MeasureSpec.AT_MOST)
        container.measure(widthMeasureSpec, heightMeasureSpec)
        container.layout(0, 0, container.measuredWidth, container.measuredHeight)
    }

    private fun measureAndLayoutExactlySize(container: ViewGroup) {
        val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(WIDTH, View.MeasureSpec.EXACTLY)
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(HEIGHT, View.MeasureSpec.EXACTLY)
        container.measure(widthMeasureSpec, heightMeasureSpec)
        container.layout(0, 0, container.measuredWidth, container.measuredHeight)
    }


    companion object {
        private const val TOTAL = 100

        private const val WIDTH = 1080

        private const val HEIGHT = 1920
    }
}