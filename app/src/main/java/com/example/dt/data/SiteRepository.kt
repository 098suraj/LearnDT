package com.example.dt.data

import com.example.dt.util.NetworkingService
import javax.inject.Inject

class SiteRepository @Inject constructor(private val networkingService: NetworkingService) {
    suspend fun fetchSite() = networkingService.fetchSite()
    suspend fun fetchCodeForces() = networkingService.fetchCodeForces()
    suspend fun fetchCodeChef() = networkingService.fetchCodeChef()
    suspend fun fetchCsAcademy() = networkingService.fetchCsAcademy()
    suspend fun fetchAtCoder() = networkingService.fetchAtCoder()
    suspend fun fetchKickStart() = networkingService.fetchKickStart()
    suspend fun fetchTopCoder() = networkingService.fetchTopCoder()
    suspend fun fetchLeetCode() = networkingService.fetchLeetCode()
    suspend fun fetchHackerEarth() = networkingService.fetchHackerEarth()
    suspend fun fetchHackerRank() = networkingService.fetchHackerRank()

}