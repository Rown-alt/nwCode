package com.example.nwcode.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nwcode.api.RetrofitInstance
import com.example.nwcode.models.PhotoById
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThirdPageViewModel : ViewModel() {
    var photoById = MutableLiveData<PhotoById>()
    var exception = MutableLiveData<Int>()
    fun getPhotoById(id : String){
        viewModelScope.launch(Dispatchers.IO) {
            RetrofitInstance.api.getPhoto(id).onSuccess {
                photoById.postValue(it)
            }
            RetrofitInstance.api.getPhoto(id).onFailure {
                Log.e("Request",it.localizedMessage)
                exception.postValue(1)
            }
        }
    }
}