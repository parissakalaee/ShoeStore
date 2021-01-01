package com.udacity.shoestore.screens.shoedetail

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    var shoe: Shoe = Shoe("", 0.0, "", "", mutableListOf())
        get() = field.apply {
            name = this@ShoeViewModel.name.value!!
            size = this@ShoeViewModel.size.value?.toDouble() ?: 0.0
            company = this@ShoeViewModel.company.value!!
            description = this@ShoeViewModel.description.value!!
        }

    //create the list
    private val shoesList: MutableList<Shoe> = mutableListOf()

    //create the live data
    private val _shoeData = MutableLiveData<List<Shoe>>()
    val shoeData: LiveData<List<Shoe>>
        get() = _shoeData

    init {
    }

    fun addShoe(v: View, shoe: Shoe) {
        shoesList.add(shoe)
        _shoeData.value = shoesList
    }

}
