package com.example.nwcode.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nwcode.api.RetrofitInstance
import com.example.nwcode.models.Collection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondPageViewModel : ViewModel() {
    var collection = MutableLiveData<Collection>()
    var exception =  MutableLiveData<Int>()
    fun getCollection(query : String){
        viewModelScope.launch(Dispatchers.IO) {
            RetrofitInstance.api.getCollections(query).onSuccess {
                collection.postValue(it)
            }
            RetrofitInstance.api.getCollections(query).onFailure {
                Log.e("Request", it.localizedMessage!!)
                exception.postValue(1)
            }
        }
    }
}