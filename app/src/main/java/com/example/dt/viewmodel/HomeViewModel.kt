package com.example.dt.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.dt.util.CoroutinesDispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val coroutineDispatcher: CoroutinesDispatcherProvider
) : ViewModel() {

    private val _liveStatus = MutableStateFlow<SnapshotStateList<Int>>(mutableStateListOf<Int>())

    val listStatus: StateFlow<SnapshotStateList<Int>>
        get() = _liveStatus

    fun listOperation(snapshotStateList: SnapshotStateList<Int>) {
        _liveStatus.value = snapshotStateList

        println(_liveStatus.value.size)
    }
}





