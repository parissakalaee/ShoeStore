package com.udacity.shoestore.model

import androidx.lifecycle.MutableLiveData

data class User(var email: MutableLiveData<String>, var password: MutableLiveData<String>)
