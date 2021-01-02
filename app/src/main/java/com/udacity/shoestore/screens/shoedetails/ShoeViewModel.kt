package com.udacity.shoestore.screens.shoedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _isTriggered = MutableLiveData<Boolean>()
    val isRedirect: LiveData<Boolean>
        get() = _isTriggered

    init {
        _isTriggered.value = false
        _shoeList.value = ArrayList()
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        _isTriggered.value = true
    }

    fun redirectCompleted() {
        _isTriggered.value = false
    }
}
