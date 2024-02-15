package com.example.calmwave.screens


import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calmwave.R


@Composable
fun Community(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1DBD3)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


        ) {
        Box(modifier = Modifier
            .fillMaxWidth(0.95f)
            .clip(RoundedCornerShape(8.dp))){
            Button(
                onClick = { navController.navigate("Listofcommunities") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xff560bad))
                ,
                colors = ButtonDefaults.buttonColors(
                    androidx.compose.ui.graphics.Color.Transparent
                ),
            ) {
                Text(
                    text = "Join Community",
                    fontSize = 30.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier
            .fillMaxWidth(0.95f)
            .clip(RoundedCornerShape(8.dp))){
            Button(
                onClick = { navController.navigate("MicroPollutantsActivity") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xff7209b7))
                ,
                colors = ButtonDefaults.buttonColors(
                    androidx.compose.ui.graphics.Color.Transparent
                ),
            ) {
                Text(
                    text = "Build Community",
                    fontSize = 30.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier
            .fillMaxWidth(0.95f)
            .clip(RoundedCornerShape(8.dp))){
            Button(
                onClick = { navController.navigate("MicroPollutantsActivity") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xffb5179e))
                ,
                colors = ButtonDefaults.buttonColors(
                    androidx.compose.ui.graphics.Color.Transparent
                ),
            ) {
                Text(
                    text = "Solo Leveling",
                    fontSize = 30.sp
                )
            }
        }

    }
    Column {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }

    }





}
