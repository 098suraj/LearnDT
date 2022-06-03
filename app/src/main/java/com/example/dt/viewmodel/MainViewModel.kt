package com.example.dt.viewmodel

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dt.data.SiteRepository
import com.example.dt.util.CoroutinesDispatcherProvider
import com.example.dt.util.models.SiteApiAllResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
@SuppressLint("StaticFieldLeak")
class MainViewModel @Inject constructor(
    private val repository: SiteRepository,
    @ApplicationContext private val applicationContext: Context,
    private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider
):ViewModel() {

    private val _uiState= MutableStateFlow<SiteAppState>(SiteAppState.Empty)
    val uiState:StateFlow<SiteAppState> = _uiState
    init {
        fetchSite()
    }

    private fun fetchSite() {
      _uiState.value = SiteAppState.Loading
        viewModelScope.launch(coroutinesDispatcherProvider.IO()){
            try {
                val response=repository.fetchSite()
                if (response.isSuccessful){
                 _uiState.value= response.body()?.let { SiteAppState.Loaded(it) }!!

                }
                System.out.println(response)
            }catch (ex:Exception){
                Log.e(TAG, "fetchSite: ",ex )
            }
        }
    }

    sealed class SiteAppState{
        object Empty: SiteAppState()
        object Loading: SiteAppState()
        class Loaded(val list:MutableList<SiteApiAllResponseItem>) : SiteAppState()
        class Error(val message:String): SiteAppState()
    }

}