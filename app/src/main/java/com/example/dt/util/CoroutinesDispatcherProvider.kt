package com.example.dt.util

import kotlinx.coroutines.Dispatchers

class CoroutinesDispatcherProvider {
    fun IO() = Dispatchers.IO
    fun Default() = Dispatchers.Default
    fun Main() = Dispatchers.Main
}