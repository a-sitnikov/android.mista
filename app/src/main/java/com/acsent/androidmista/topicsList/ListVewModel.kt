package com.acsent.androidmista.topicsList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acsent.androidmista.network.API
import com.acsent.androidmista.network.TopicsListItem
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class ListViewModel : ViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> = _status

    private val _list = MutableLiveData<List<TopicsListItem>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val list: LiveData<List<TopicsListItem>> = _list

    init {
        fetchData()
    }

    private fun fetchData() {

        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _list.value = API.retrofitService.getTopicsList()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _list.value = listOf()
                Log.e("topicsList.getList", e.toString())
            }
        }
    }

    fun update() {
        fetchData()
    }
}