package com.learn.growthcodelab.navigation.game

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class GameEntranceFragment: BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_game_entrance
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.btn_game_play).setOnClickListener {
            findNavController().navigate(GameEntranceFragmentDirections.actionNavigateToRegister())
        }
    }

}