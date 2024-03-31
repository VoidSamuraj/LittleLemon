package com.example.littlelemon

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemon.composables.DishDetails
import com.example.littlelemon.composables.HomeScreen
import com.example.littlelemon.composables.Onboarding
import com.example.littlelemon.composables.Profile
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPref =  applicationContext.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = if(sharedPref.getBoolean("loggedIn",false))Home.route else Onboarding.route) {
                    composable(Onboarding.route){
                        Onboarding(navController,sharedPref)
                    }
                    composable(Home.route) {
                        HomeScreen(navController)
                    }
                    composable(Profile.route){
                        Profile(navController, sharedPref)
                    }
                    composable(
                        DishDetails.route + "/{${DishDetails.argDishId}}",
                        arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
                    ) {
                        val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                        DishDetails(id, navController)
                    }
                }
            }
        }
    }
}
