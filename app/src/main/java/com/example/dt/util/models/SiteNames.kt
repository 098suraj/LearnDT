package com.example.dt.util.models
import androidx.compose.ui.graphics.Color
import com.example.dt.R
import kotlin.random.Random

data class SiteNames(
    val name:String,
    val color:Color= getRandomColor().random(),
    val image:Int=0,
    val enabled:Boolean = false,

    )
data class ColorSite(
    val color: Color
)
fun getRandomColor()= listOf(
    Color(0xFF4FC3F7),
    Color(0xFF79E4CA),
    Color(0xFFCE93D8),
    Color(0xFFFFE082),
    Color(0xC3FF5722),
    Color(0xCD673AB7),
    Color(0xCBE91E63),
)



fun getSiteNameList() = listOf(
    SiteNames("HackerRank", image = R.drawable.hack,),
    SiteNames("CodeChef"),
    SiteNames("CodeForces"),
    SiteNames("CsAcademy"),
    SiteNames("AtCoder"),
    SiteNames("TopCoder"),
    SiteNames("LeetCode"),
    SiteNames("HackerEarth"),

)