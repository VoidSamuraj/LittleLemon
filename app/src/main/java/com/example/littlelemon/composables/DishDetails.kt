package com.example.littlelemon.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.DishRepository
import com.example.littlelemon.R

@Composable
fun DishDetails(id: Int=1, navController: NavHostController) {
    val dish = requireNotNull(DishRepository.getDish(id))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(10.dp,0.dp)) {
        TopAppBar(navController)
        Image(painter = painterResource(id = dish.imageResource),
            contentDescription ="Dish image",
            modifier=Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth )
        Column {
            Text(text = dish.name, style = MaterialTheme.typography.h1)
            Text(text = dish.description, style = MaterialTheme.typography.body1)
            Counter()
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.add_for)+" $${dish.price}", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically))
            }
        }
    }
}

@Composable
fun Counter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        var counter by remember {
            mutableStateOf(1)
        }
        TextButton(
            onClick = {
                counter--
            }
        ) {
            Text(
                text = "-",
                style = MaterialTheme.typography.h2
            )
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.h2
            )
        }
    }
}

