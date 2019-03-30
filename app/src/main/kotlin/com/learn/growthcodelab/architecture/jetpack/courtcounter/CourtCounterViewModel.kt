package com.learn.growthcodelab.architecture.jetpack.courtcounter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CourtCounterViewModel : ViewModel(){

    val teamAScore : MutableLiveData<Int> = MutableLiveData()
    val teamBScore : MutableLiveData<Int> = MutableLiveData()

    init {
        teamAScore.value = 0
        teamBScore.value = 0
    }
}