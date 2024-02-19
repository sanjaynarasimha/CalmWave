package com.example.calmwave.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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

data class Community(val name: String, val destination: String, val imageRes: Int)

@Composable
fun Listofcommunities(navController: NavHostController) {
    val communityList = listOf(
        Community(name = "Get lost in music", destination = "Profile", imageRes = R.drawable.music),
        Community(name = "Get Moving", destination = "Comm", imageRes = R.drawable.move_on),
        Community(name = "Unplug and unwind", destination = "Comm", imageRes = R.drawable.unplug),
        Community(name = "Volunteer", destination = "Volunteer", imageRes = R.drawable.volenteering),
        Community(name = "Watch Favorite Movie", destination = "Comm", imageRes = R.drawable.movie),
        Community(name = "Keep a journal", destination = "Comm", imageRes = R.drawable.journeling),
        Community(name = "Join a community", destination = "Comm", imageRes = R.drawable.join_comm),
        Community(name = "Learn something new", destination = "Comm", imageRes = R.drawable.learn)
    )

    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(communityList) { community ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate(community.destination) }
            ) {
                Image(
                    painter = painterResource(id = community.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .width(300.dp)
                        .height(1000.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )
                Button(
                    onClick = { navController.navigate(community.destination) },
                    modifier = Modifier
                        .width(300.dp)
                        .height(1000.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent
                    ),
                ) {
                    Text(
                        text = community.name,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = getCommunityTextColor(community.name) // Use a function to get text color
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Column {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }
}

@Composable
fun getCommunityTextColor(communityName: String): Color {
    return when (communityName) {
        "Get lost in music" -> Color.White
        "Get Moving" -> Color(android.graphics.Color.parseColor("#00FF00")) // Green
        "Unplug and unwind" -> Color(android.graphics.Color.parseColor("#283618"))
        "Volunteer" -> Color.Magenta
        "Watch Favorite Movie" -> Color(android.graphics.Color.parseColor("#eddea4"))
        "Keep a journal" -> Color(android.graphics.Color.parseColor("#582f0e"))
        "Join a community" -> Color.Gray
        "Learn something new" -> Color.Yellow
        else -> Color.Black
    }
}
