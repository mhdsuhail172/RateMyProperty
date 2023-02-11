package com.mhdsuhail.ratemyproperty.ui.propertycard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mhdsuhail.ratemyproperty.ui.theme.primaryTextColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhdsuhail.ratemyproperty.R
import com.mhdsuhail.ratemyproperty.data.Property
import com.mhdsuhail.ratemyproperty.data.preview.PropertyPreviewParameterProvider
import com.mhdsuhail.ratemyproperty.ui.theme.RateMyPropertyTheme

@Preview
@Composable
fun PropertyInfoCardPreview(
    @PreviewParameter(PropertyPreviewParameterProvider::class) properties: Property
) {
    PropertyInfoCard(properties)
}

@Composable
fun PropertyInfoCard(property: Property) {

    RateMyPropertyTheme() {

        Card(shape = RoundedCornerShape(40.dp), modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .padding(top = 5.dp, bottom = 5.dp)) {
            Surface {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier
                        .fillMaxHeight(0.65F)
                        .fillMaxWidth()){
                        Image(
                            painter = painterResource(id = R.drawable.propertyprop2),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 1.dp
                            )
                            .fillMaxSize(0.5F)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(top = 1.dp)
                                .fillMaxWidth(),
                            text = "${property.currency}" + property.price.toString(),
                            fontSize = 35.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = primaryTextColor
                        )
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(top = 1.dp)
                                    .fillMaxWidth(0.85F),
                                text = "${property.address.street} - ${property.address.city}," + " ${property.address.state}",
                                fontSize = 18.sp,
                                color = primaryTextColor
                            )
                            IconButton( modifier = Modifier.fillMaxSize(),
                                onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Favourites",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}