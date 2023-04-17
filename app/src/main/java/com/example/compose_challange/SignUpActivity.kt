package com.example.compose_challange

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.compose_challange.ui.theme.Compose_challangeTheme
import com.google.gson.Gson

class SignUpActivity : ComponentActivity() {

    var phone : String by mutableStateOf("")
    var otp : String by mutableStateOf("")
    var firstName : String by mutableStateOf("")
    var secondName : String by mutableStateOf("")

    fun phoneChange(value : String){
        phone = value
    }

    fun otpChange(value : String){
        otp = value
    }

    fun firstNameChanged(value : String){
        firstName = value
    }

    fun secondNameChanged(value : String){
        secondName = value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Compose_challangeTheme {
                // A surface container using the 'background' color from the theme
               //detailScreenUI()
                signupUI()
            }
        }


    }



    @Composable
    fun signupUI(){


        Surface(color = MaterialTheme.colors.background) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Create an Account",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        OutlinedTextField(
                            value = firstName,
                            onValueChange = { if (it.length <= 10 )firstNameChanged(it) },
                            label = { Text("First Name") },
                            singleLine = true,
                            modifier = Modifier
                                .weight(1f)
                                .padding(0.dp, 0.dp, 5.dp, 0.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        OutlinedTextField(
                            value = secondName,
                            onValueChange = { if (it.length <= 10 )secondNameChanged(it) },
                            label = { Text("Second Name") },
                            singleLine = true,
                            modifier = Modifier
                                .weight(1f)
                                .padding(5.dp, 0.dp, 0.dp, 0.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                    }

                    RadioButtonsGroup()


                    OutlinedTextField(
                        value = phone,
                        onValueChange = { if (it.length <= 10 )phoneChange(it) },
                        label = { Text("Phone") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    OutlinedTextField(
                        value = otp,
                        onValueChange = { if (it.length <= 6 )otpChange(it) },
                        label = { Text("OTP") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )


                    Button(
                        onClick = { gotoMainActivty() },
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Text("Sign Up")
                    }
                }
            }
        }

    @Composable
    fun RadioButtonsGroup() {
        val options = listOf("Male", "Female", "Other")
        var selectedOption by remember { mutableStateOf(options[0]) }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            options.forEach { option ->
                Row(
                    modifier = Modifier.padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option },
                        modifier = Modifier.padding(end = 2.dp)
                    )
                    Text(option)
                }
            }
        }
    }

    private fun gotoMainActivty() {
        if (/*phone.length == 10 && otp.length == 6 */ true) {
            startActivity(Intent(this, MainActivity::class.java))
        }else {
            Toast.makeText(this,"Phone or Otp mismatch !", Toast.LENGTH_SHORT).show()
        }
    }
}