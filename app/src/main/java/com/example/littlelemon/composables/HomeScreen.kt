package com.example.littlelemon.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.littlelemon.Dish
import com.example.littlelemon.DishRepository
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeScreen(navController: NavHostController) {
    val dishesState: MutableStateFlow<List<Dish>> =
        MutableStateFlow(DishRepository.dishes)

    Column {
        TopAppBar(navController)
        UpperPanel()
        LowerPanel(navController, dishesState)
    }
}
