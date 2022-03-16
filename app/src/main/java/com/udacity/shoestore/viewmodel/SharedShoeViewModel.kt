package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.model.Shoe

class SharedShoeViewModel : ViewModel() {
    var shoe: MutableLiveData<Shoe>

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _isShoeAdded = MutableLiveData<Boolean>()
    val isShoeAdded: LiveData<Boolean>
        get() = _isShoeAdded

    init {
        _isShoeAdded.value = false
        _shoeList.value = ArrayList()
        shoe = MutableLiveData<Shoe>(Shoe("", 0.0, "", "", mutableListOf()))
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        _isShoeAdded.value = true
    }

    fun onAddShoe() {
        _isShoeAdded.value = false
        shoe.value = Shoe("", 0.0, "", "", mutableListOf())
    }
}
