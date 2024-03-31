package com.example.littlelemon.composables

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.Home
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Onboarding(navController: NavHostController, sharedPref:SharedPreferences) {
    Column {
        TopAppBar()
        Text(text =  stringResource(id = R.string.onboarding_header),
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(LittleLemonColor.green)
                .padding(30.dp),
            fontSize = 24.sp)
        PersonalInfo(buttonName = stringResource(id = R.string.register), checkIfFieldsAreEmpty = true, sharedPref= sharedPref, inputEnabled = true){
            navController.navigate(Home.route)
        }
    }
}
