package com.learn.growthcodelab.performance

import android.os.AsyncTask
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.learn.growthcodelab.activity.BaseActivity
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit

class FrameMetricsActivity : BaseActivity(){


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
        }
    }

    companion object {
        private const val TOTAL = 100
    }
}