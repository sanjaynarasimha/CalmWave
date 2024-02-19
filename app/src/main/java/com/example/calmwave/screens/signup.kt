package com.example.calmwave.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calmwave.R

@Composable
fun Signup(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var signup_emailstate by remember { mutableStateOf("") }
    var signup_passwordState by remember { mutableStateOf("") }
    var  signup_repasswordState by remember { mutableStateOf("") }

    Column {
        Image(
            painter = painterResource(id = R.drawable.logogirltransp), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }


        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFFE1DBD3)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Back button
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text("Username")
            OutlinedTextField(
                value = username,
                onValueChange = {
                    if (it.length <= 16) {
                        username = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                }
            )

            // First Name TextField
            Text("First Name")
            OutlinedTextField(
                value = firstname,
                onValueChange = { firstname = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                }
            )

            // Last Name TextField
            Text("Last Name")
            OutlinedTextField(
                value = lastname,
                onValueChange = { lastname = it  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                }
            )

            // Email TextField
            Text("Email")
            OutlinedTextField(
                value = signup_emailstate,
                onValueChange = {  signup_emailstate = it  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                }
            )

            // Password TextField
            Text("Password")
            OutlinedTextField(
                value = signup_passwordState,
                onValueChange = {  signup_passwordState = it  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                }
            )

            // Re-enter Password TextField
            Text("Re-enter Password")
            OutlinedTextField(
                value = signup_repasswordState,
                onValueChange = {  signup_repasswordState = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                }
            )

            // Sign Up Button
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(21.dp))
            ) {
                Button(
                    onClick = { navController.navigate("homescreen") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp) // Set the same height as the text field
                        .padding(5.dp)
                        .background(Color(0xff8338ec)),
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                ) {
                    Text(
                        text = "sign up",
                        fontSize = 20.sp
                    )
                }

            }
        }

}
