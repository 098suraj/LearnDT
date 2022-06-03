package com.example.dt.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dt.R
import com.example.dt.ui.theme.*
import com.example.dt.util.Feature
import com.example.dt.util.models.SiteApiAllResponseItem
import com.example.dt.util.standardQuadFromTo
import com.example.dt.viewmodel.MainViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SiteContests(
    navHostController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Title(modifier = Modifier.weight(.2f))
            UserName(string = "Suraj", Modifier.weight(.5f))
            FeatureSection(
                Modifier.weight(1f,false),
                features = listOf(
                    Feature(
                        title = "Previous Contests",

                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Upcoming Contests",

                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                )
            )


        }

    }
}

@Composable
fun LazySiteDisplay(modifier: Modifier,list:List<SiteApiAllResponseItem>) {
    LazyColumn(modifier = modifier.fillMaxSize()){
        items(list) { it ->
            Text(text = it.in24Hours)
        }
    }
}


@Composable
fun Title(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = buildAnnotatedString {
                append("Code Dt")
                addStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.Orange)
                    ),
                    start = 0,
                    end = 4
                )
                addStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.Gray)
                    ),
                    start = 5,
                    end = 7
                )
            },
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = Color.Cyan,
            textAlign = TextAlign.Center

        )
    }
}

@Composable
fun UserName(string: String, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp),
        horizontalArrangement = Arrangement.Start

    ) {

        val name = remember {
            mutableStateOf("HI,\r\n$string")
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(text = buildAnnotatedString {
                append(name.value)
                addStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.Orange),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif
                    ),
                    start = 0,
                    end = 3
                )
                addStyle(
                    style = SpanStyle(
                        color = colorResource(id = R.color.Gray)
                    ),
                    start = 3,
                    end = name.value.length
                )
            }
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun FeatureSection(modifier: Modifier, features: List<Feature>) {
    Column(
        modifier = modifier
            .fillMaxWidth()

    ) {

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])

            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1.7f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 15.sp,
                fontSize = 16.sp,

                modifier = Modifier.align(Alignment.TopStart)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}



