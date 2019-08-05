package com.learn.growthcodelab.activityfield

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import java.io.Serializable

class DuckActivity : BaseActivity() {

    private lateinit var duck: Duck

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Duck", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_duck)
        duck = (intent.getSerializableExtra(INTENT_EXTRA_DUCK) as? Duck) ?: throw IllegalArgumentException("")
        findViewById<TextView>(R.id.tv_duck_name).text = duck.name.toUpperCase()
    }


    class Duck(val name: String) : Serializable


    companion object {
        private const val INTENT_EXTRA_DUCK = "intent_extra_duck"

        fun start(context: Context) {
            val duck = Duck("Not a Duck")
            Intent(context, DuckActivity::class.java).apply {
                putExtra(INTENT_EXTRA_DUCK, duck)
            }.let { context.startActivity(it) }

        }
    }
}