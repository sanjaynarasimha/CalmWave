package com.example.calmwave.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calmwave.R

@Composable
fun homescreen(navController: NavHostController) {
    // Use remember to create mutable state variables for the text fields
    val logoImage = painterResource(id = R.drawable.logo)
    var usernameState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFE1DBD3)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = logoImage,
            contentDescription = null, // Set a proper content description
            modifier = Modifier
                .width(300.dp)
                .height(150.dp)
                .padding(10.dp)
        )

        OutlinedTextField(
            value = usernameState,
            onValueChange = { usernameState = it },
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Add appropriate padding
        )

        OutlinedTextField(
            value = passwordState,
            onValueChange = { passwordState = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Add appropriate padding
        )
        Box(modifier = Modifier.fillMaxWidth(0.95f)
            .clip(RoundedCornerShape(21.dp))){
            Button(
                onClick = { navController.navigate("Community") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp) // Set the same height as the text field
                    .padding(5.dp).background(Color(0xff8338ec))
                ,
                colors = ButtonDefaults.buttonColors(
                    Color.Transparent
                ),
            ) {
                Text(
                    text = "sign in",
                    fontSize = 20.sp
                )
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Forgot Password link
            Text(
                text = "Forgot Password",
                modifier = Modifier.clickable {
                    // Navigate to the Forgot Password screen when clicked
                    navController.navigate("Forgotpassword")
                }
            )

            // Sign Up link
            Text(
                text = "Sign Up",
                modifier = Modifier.clickable {
                    // Navigate to the Sign Up screen when clicked
                    navController.navigate("Signup")
                }
            )
        }

        // Additional UI elements can be added here
    }
}
