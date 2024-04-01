package com.example.littlelemon.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.Dish
import com.example.littlelemon.DishRepository
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@Composable
fun UpperPanel(dishes: MutableStateFlow<List<Dish>>) {
    var search by remember { mutableStateOf( "") }
    Column(
        modifier = Modifier
            .background(LittleLemonColor.green)
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)

    ) {
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.yellow
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(top = 5.dp, bottom = 20.dp)
        ) {
            Column (verticalArrangement = Arrangement.SpaceBetween, modifier =Modifier.fillMaxHeight()) {
                Text(
                    text = stringResource(id = R.string.location),
                    fontSize = 24.sp,
                    color = LittleLemonColor.cloud
                )
                Text(
                    text = stringResource(id = R.string.description),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(top = 20.dp, end = 20.dp)
                        .fillMaxWidth(0.6f),
                    color = LittleLemonColor.cloud
                )
            }
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "Upper Panel Image",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
        TextField( value = search, onValueChange = {
            search = it
            dishes.update {
                DishRepository.getDishesFilteredBy(search)
            }
            }
            ,shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = LittleLemonColor.lightGreen, focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
            singleLine = true,
            placeholder = {
                Text(text = stringResource(id = R.string.search_phrase), color = LittleLemonColor.green)
            },
            leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription ="Search", tint = Color.Black )
        }, modifier = Modifier.fillMaxWidth())

    }
}

