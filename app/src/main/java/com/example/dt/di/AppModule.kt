package com.example.dt.di

import android.content.Context
import com.example.dt.data.DataStoreRepository
import com.example.dt.util.CoroutinesDispatcherProvider
import com.example.dt.util.NetworkingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) = DataStoreRepository(context = context)

    @Provides
    @Singleton
    fun provideRetrofit(): NetworkingService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkingService::class.java)


    @Provides
    fun provideCoroutinesDispatcher() = CoroutinesDispatcherProvider()

    companion object {
        const val BASE_URL = "https://kontests.net"
    }
}


