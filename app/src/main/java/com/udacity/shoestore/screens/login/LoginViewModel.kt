package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.model.User

class LoginViewModel : ViewModel() {
    val user = MutableLiveData<User>()
//    val email = MutableLiveData<String>()
//    val password = MutableLiveData<String>()
}