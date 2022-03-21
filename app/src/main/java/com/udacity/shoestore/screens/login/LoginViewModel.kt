package com.udacity.shoestore.screens.login

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.model.User

class LoginViewModel : ViewModel() {
    val user = MediatorLiveData<User>()
//    val email = MutableLiveData<String>()
//    val password = MutableLiveData<String>()
}