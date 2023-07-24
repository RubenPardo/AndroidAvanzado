package com.example.androidavanzado.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidavanzado.Model
import com.example.androidavanzado.domain.usecases.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ListViewModel (
    private val getHeroListUseCase: GetHeroListUseCase
) : ViewModel() {


    private val _listItem = MutableLiveData<List<Model>>()
    val listItem: LiveData<List<Model>> = _listItem

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>  get() =  _loading

    fun getList(){
        viewModelScope.launch (Dispatchers.IO){
            _loading.postValue(true)
            delay(1000)
            _listItem.postValue(getHeroListUseCase.invoke())
            _loading.postValue(false)
        }
    }


}