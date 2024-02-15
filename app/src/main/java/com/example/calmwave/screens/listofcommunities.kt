package com.example.calmwave.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calmwave.R

data class Community(val name: String, val destination: String)

@Composable
fun Listofcommunities(navController: NavHostController) {
    val CommunityList = listOf(
        Community(name = "Supportive Minds Community", destination = "Comm"),
        Community(name = "Wellness Together Hub", destination = "Comm"),
        Community(name = "Mindful Living Circle", destination = "Comm"),
        Community(name = "Hope and Healing Network", destination = "Comm"),
        Community(name = "Calm Reflections Group", destination = "Comm"),
        Community(name = "Emotional Resilience Collective", destination = "Comm"),
        Community(name = "Mindfulness and Compassion Society", destination = "Comm"),
        Community(name = "Mental Health Allies Association", destination = "Comm"),

        // Add more comm as needed
    )

//    Column {
//        Image(
//
//            painter = painterResource(id = R.drawable.all_pic), contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxSize()
//        )
//    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {

        item {
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "List Of Communities",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(android.graphics.Color.parseColor("#ff582f0e")))
            Spacer(modifier = Modifier.height(40.dp))
        }

        items(CommunityList) { community ->
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate(community.destination) }
            ) {
                Button(
                    onClick = { navController.navigate(community.destination) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color(0xff7209b7)),
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                ) {
                    Text(
                        text = community.name,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
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