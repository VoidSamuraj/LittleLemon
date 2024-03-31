package com.example.littlelemon.composables

import android.content.SharedPreferences
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColor


/**
 * @param buttonName name of button under personal info
 * @param checkIfFieldsAreEmpty if true, TextFields needs to have value to call onButtonClick
 * @param onButtonClick code executed on click if input fields are no empty
 */
@Composable
fun PersonalInfo(buttonName:String,checkIfFieldsAreEmpty:Boolean, sharedPref: SharedPreferences, inputEnabled:Boolean = true, onButtonClick:()->Unit) {
    val fName = remember { mutableStateOf( sharedPref.getString("fName", "")) }
    val lName = remember { mutableStateOf( sharedPref.getString("lName", "")) }
    val email = remember { mutableStateOf( sharedPref.getString("email", "")) }

    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Text(text = stringResource(id = R.string.onboarding_personal),
            color = LittleLemonColor.green,
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 40.dp)
        )

        Text( stringResource(id = R.string.first_name),color = LittleLemonColor.green,fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = fName.value!!,
            onValueChange = { newValue -> fName.value=newValue},
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            enabled = inputEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        Text( stringResource(id = R.string.last_name),color = LittleLemonColor.green,fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = lName.value!!,
            onValueChange = { newValue ->lName.value=newValue},
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            enabled = inputEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        Text(stringResource(id = R.string.email),color = LittleLemonColor.green,fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = email.value!!,
            onValueChange = { newValue ->email.value=newValue },
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            enabled = inputEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick ={
            if(!checkIfFieldsAreEmpty || (fName.value!="" && lName.value!="" && email.value!="")) {

                sharedPref.edit().apply {
                    putBoolean("loggedIn",true)
                    putString("fName",fName.value)
                    putString("lName",lName.value)
                    putString("email",email.value)
                }.apply()
                onButtonClick()
            }
        },
            border = BorderStroke(2.dp, LittleLemonColor.orange),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = LittleLemonColor.yellow),
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Text(text = buttonName, color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}