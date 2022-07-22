package com.example.nwcode.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nwcode.api.RetrofitInstance
import com.example.nwcode.models.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstPageViewModel : ViewModel() {
    var collections = MutableLiveData<List<Results>>()
    var exception = MutableLiveData<Int>()
    fun getCollections(){
        viewModelScope.launch(Dispatchers.IO) {
            val array : MutableList<Results> = mutableListOf()
            RetrofitInstance.api.getCollections("Volleyball").onSuccess {
                    array += it.results[0]
                    collections.postValue(array)
            }
            RetrofitInstance.api.getCollections("Apple").onSuccess {
                array += it.results[0]
                collections.postValue(array)
            }
            RetrofitInstance.api.getCollections("Dota 2").onSuccess {
                array += it.results[0]
                collections.postValue(array)
            }
            RetrofitInstance.api.getCollections("Office").onSuccess {
                array += it.results[0]
                collections.postValue(array)
            }
            RetrofitInstance.api.getCollections("Moon").onSuccess {
                array += it.results[0]
                collections.postValue(array)
            }
            RetrofitInstance.api.getCollections("Skate").onSuccess {
                array += it.results[0]
                collections.postValue(array)
            }
            RetrofitInstance.api.getCollections("Mice").onSuccess {
                array += it.results[0]
                collections.postValue(array)
            }
            RetrofitInstance.api.getCollections("Volleyball").onFailure {
                exception.postValue(1)
            }
        }
    }
}