package com.learn.growthcodelab.navigation.game

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.learn.growthcodelab.R
import com.learn.growthcodelab.fragment.BaseFragment

class GameRegisterFragment: BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_game_register
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.btn_game_sign_up).setOnClickListener {
            it.findNavController().navigate(R.id.action_navigate_to_game_match)
        }
    }
}