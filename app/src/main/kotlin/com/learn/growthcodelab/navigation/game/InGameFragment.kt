package com.learn.growthcodelab.navigation.game

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment


class InGameFragment : BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_in_game
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.btn_first_option).setOnClickListener {
            findNavController().navigate(InGameFragmentDirections.actionNavigateToGameOver())
        }
        view.findViewById<View>(R.id.btn_second_option).setOnClickListener {
            findNavController().navigate(InGameFragmentDirections.actionNavigateToGameResultWinner())
        }
    }
}