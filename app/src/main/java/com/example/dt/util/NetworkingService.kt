package com.example.dt.util

import com.example.dt.util.models.SiteApiAllResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface NetworkingService {
   @GET("/api/v1/all")
   suspend fun fetchSite():Response<MutableList<SiteApiAllResponseItem>>
   @GET("/api/v1/codeforces")
   suspend fun fetchCodeForces():Response<List<SiteApiAllResponseItem>>

   @GET("/api/v1/top_coder")
   suspend fun fetchTopCoder():Response<List<SiteApiAllResponseItem>>

   @GET("/api/v1/at_coder")
   suspend fun fetchAtCoder():Response<List<SiteApiAllResponseItem>>

   @GET("/api/v1/code_chef")
   suspend fun fetchCodeChef():Response<List<SiteApiAllResponseItem>>

   @GET("/api/v1/cs_academy")
   suspend fun fetchCsAcademy():Response<List<SiteApiAllResponseItem>>

   @GET("/api/v1/hacker_rank")
   suspend fun fetchHackerRank():Response<List<SiteApiAllResponseItem>>

   @GET("/api/v1/hacker_earth")
   suspend fun fetchHackerEarth():Response<List<SiteApiAllResponseItem>>

   @GET("/api/v1/kick_start")
   suspend fun fetchKickStart():Response<List<SiteApiAllResponseItem>>

   @GET("/api/v1/leet_code")
   suspend fun fetchLeetCode():Response<List<SiteApiAllResponseItem>>


}