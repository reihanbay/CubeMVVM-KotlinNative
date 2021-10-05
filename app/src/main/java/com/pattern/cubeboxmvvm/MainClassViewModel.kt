package com.pattern.cubeboxmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainClassViewModel : ViewModel() {
    var result = MutableLiveData<Int>()

    fun setResult(p: Int, l:Int, t:Int){
        result.value = p*l*t
    }
}