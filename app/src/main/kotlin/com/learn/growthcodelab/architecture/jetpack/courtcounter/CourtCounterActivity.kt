package com.learn.growthcodelab.architecture.jetpack.courtcounter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.learn.growthcodelab.R
import com.learn.growthcodelab.activity.BaseActivity
import com.learn.growthcodelab.databinding.ActivityCourtCounterBinding

class CourtCounterActivity : BaseActivity(), View.OnClickListener {

    private lateinit var viewModel: CourtCounterViewModel

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
        viewModel = ViewModelProviders.of(this).get(CourtCounterViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }

    override fun onClick(view: View) {
        var teamAScore = viewModel.teamAScore.value
        var teamBScore = viewModel.teamBScore.value
        if(teamAScore != null && teamBScore != null) {
            when (view.id) {
                R.id.btn_team_a_three_points -> teamAScore += 3
                R.id.btn_team_a_two_points -> teamAScore += 2
                R.id.btn_team_a_free_throw -> teamAScore += 1
                R.id.btn_team_b_three_points -> teamBScore += 3
                R.id.btn_team_b_two_points -> teamBScore += 2
                R.id.btn_team_b_free_throw -> teamBScore += 1
            }
            viewModel.teamAScore.value = teamAScore
            viewModel.teamBScore.value = teamBScore
        }
    }
}