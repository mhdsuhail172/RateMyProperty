package com.mhdsuhail.ratemyproperty.ui.globalui

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mhdsuhail.ratemyproperty.R
import com.mhdsuhail.ratemyproperty.ui.theme.primaryTextColor
import com.mhdsuhail.ratemyproperty.util.Routes

@Composable
fun TopActionBar(
    text: MutableState<String>,
    onClickUserButton: () -> Unit,
    isVisible: MutableState<Boolean>
) {

    AnimatedVisibility(visible = isVisible.value,
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { it }),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 15.dp)
                            .fillMaxWidth(),
                        text = text.value,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = primaryTextColor
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5f)
                ) {
                    IconButton(
                        onClick = { onClickUserButton() },
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 15.dp)
                            .clip(CircleShape)
                            .size(45.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape), // Descriptive Image
                            painter = painterResource(id = R.drawable.sample_realtor_2),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Realtor Contact Picture"
                        )
                    }
                }

            }
        }
    )

}