package com.example.littlelemon.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.Dish
import com.example.littlelemon.DishRepository
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.Shapes
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun LowerPanel(navController: NavHostController, dishes: MutableStateFlow<List<Dish>>) {
    Column {
        SortOptions()
        LazyColumn {
            itemsIndexed(dishes.value) { _, dish ->
                MenuDish(navController, dish)
            }
        }
    }
}

@Composable
fun SortOptions() {
    Column( Modifier.padding(horizontal = 10.dp )) {
        Text(
            text = stringResource(R.string.order_delivery),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(8.dp)
        )
        val elements = listOf(stringResource(id = R.string.starters), stringResource(id = R.string.mains), stringResource(id = R.string.desserts), stringResource(id = R.string.drinks))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            elements.forEach{ name ->
                myCard(text = name) {
                    
                }
            }
        }
    }

}


@Composable
fun myCard(text:String, onClick:()->Unit){
    Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.clickable { onClick() }) {
        Text(text = text, modifier = Modifier
            .background(LittleLemonColor.lightGreen)
            .padding(5.dp))
    }
}




@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun MenuDish(navController: NavHostController? = null, dish: Dish = DishRepository.getDish(1)!!) {
    Card(onClick = {
        Log.d("AAA", "Click ${dish.id}")
        navController?.navigate(com.example.littlelemon.DishDetails.route + "/${dish.id}")
    }) {
        Row(){
            Column(){
                Text(text = dish.name, style = MaterialTheme.typography.h2)
                Text(text = dish.description,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(0.dp, 5.dp))
                Text(text = "$${dish.price}",
                    style = MaterialTheme.typography.body2)
            }
            Image(painter = painterResource(id = dish.imageResource),
                contentDescription = "image",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .align(Alignment.CenterVertically))
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
    )
}
