package com.example.littlelemon.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun TopAppBar( navController: NavHostController? = null) {
    Box(contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .fillMaxWidth(0.5F)
                    .padding(vertical = 10.dp)
            )
        if(navController!=null)
            IconButton(onClick = { navController.navigate(com.example.littlelemon.Profile.route) }, Modifier.align(Alignment.CenterEnd)) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "Cart",
                    modifier = Modifier.size(48.dp),
                    colorFilter = ColorFilter.tint(LittleLemonColor.green)
                )
            }
    }
}
