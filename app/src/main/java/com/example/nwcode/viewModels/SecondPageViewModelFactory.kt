package com.example.nwcode.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SecondPageViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SecondPageViewModel() as T
    }
}