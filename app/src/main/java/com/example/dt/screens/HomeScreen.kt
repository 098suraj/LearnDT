package com.example.dt.screens


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dt.navigation.Screen
import com.example.dt.util.models.SiteNames
import com.example.dt.util.models.getSiteNameList
import com.example.dt.viewmodel.HomeViewModel
import com.example.dt.viewmodel.MainViewModel
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

val selectedList= mutableListOf<String>()
@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {


    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            FilterChipSection(
                navHostController = navHostController,
                siteList = getSiteNameList(),
            )
        }
    }
}


@Composable
fun FilterChipSection(
    navHostController: NavController,
    siteList: List<SiteNames>,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleFLowRow(siteList = siteList)
            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = {
                      if (selectedList.isNotEmpty()){
                          selectedList.forEach {
                              Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                              navHostController.popBackStack()
                              navHostController.navigate(Screen.SiteContestes.route)
                          }
                      }else
                          Toast.makeText(context,"Select Site",Toast.LENGTH_SHORT).show()
                          },
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = siteList.random().color
                )
            ) {
                Text(
                    text = "Submit",
                    modifier = Modifier.padding(5.dp)

                )
            }
        }

    }

}


@Composable
fun SimpleFLowRow(
    siteList: List<SiteNames>,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val selectedIndices =
        if (homeViewModel.listStatus.collectAsState().value.size > 0) homeViewModel.listStatus.collectAsState().value
        else {
            remember {
                mutableStateListOf<Int>()
            }

        }


    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        FlowRow(
            mainAxisAlignment = FlowMainAxisAlignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 16.dp)
                .padding(horizontal = 4.dp),

            crossAxisSpacing = 16.dp,
            mainAxisSpacing = 16.dp,
            mainAxisSize = SizeMode.Wrap

        ) {
            siteList.forEachIndexed { index, siteName ->

                Box(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = if (!selectedIndices.contains(index)) siteName.color
                            else Color.Transparent,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable(

                            onClick =
                            {
                                if (selectedIndices.contains(index)) {
                                    selectedList.remove(siteName.name)
                                    selectedIndices.remove(index)
                                    homeViewModel.listOperation(selectedIndices)
                                } else if (!selectedIndices.contains(index)) {
                                    selectedIndices.add(index)
                                    selectedList.add(siteName.name)
                                    homeViewModel.listOperation(selectedIndices)
                                }

                            },

                            )
                        .background(
                            color =
                            if (selectedIndices.contains(index)) {
                                siteName.color
                            } else Color.Transparent,
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier.padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(com.example.dt.R.drawable.img),

                            contentDescription = null,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(35.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text =
                            if (selectedIndices.contains(index))
                                "✓ ${siteName.name}" else siteName.name,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(end = 16.dp)
                        )
                    }

                }
            }
        }
    }
}




