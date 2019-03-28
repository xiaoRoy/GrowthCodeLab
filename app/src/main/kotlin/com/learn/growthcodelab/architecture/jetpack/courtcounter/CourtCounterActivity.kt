package com.learn.growthcodelab.architecture.jetpack.courtcounter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityCourtCounterBinding

class CourtCounterActivity : BaseActivity(), View.OnClickListener {

    private var teamAPoints = 0
    private var teamBPoints = 0

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, CourtCounterActivity::class.java))
        }
    }

    private lateinit var binding: ActivityCourtCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_court_counter)
        binding.clickHandler = this
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_team_a_three_points -> teamAPoints += 3
            R.id.btn_team_a_two_points -> teamAPoints += 2
            R.id.btn_team_a_free_throw -> teamAPoints += 1
            R.id.btn_team_b_three_points -> teamBPoints += 3
            R.id.btn_team_b_two_points -> teamBPoints += 2
            R.id.btn_team_b_free_throw -> teamBPoints += 1
        }
        binding.tvTeamAPoint.text = teamAPoints.toString()
        binding.tvTeamBPoint.text = teamBPoints.toString()
    }
}