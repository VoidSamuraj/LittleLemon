package com.example.littlelemon.composables

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.littlelemon.R

@Composable
fun Profile(navController: NavHostController, sharedPref:SharedPreferences){
    PersonalInfo(buttonName = stringResource(id = R.string.logout), checkIfFieldsAreEmpty = false, sharedPref= sharedPref, inputEnabled = false){
        sharedPref.edit().clear().apply()
        navController.navigate(com.example.littlelemon.Onboarding.route)
    }
}