package com.example.calmwave.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
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

@Composable
fun Profile(navController: NavHostController) {
    // List of items with your own data
    val customItems = listOf(
        CustomItem("CHILL SONGS", "Subtitle 1", R.drawable.music, "https://open.spotify.com/playlist/7hJfYpKLDQwmeHIPTmNS5y?si=91709b68ffe44762&nd=1&dlsi=c64d7c0a00074c21"),
        CustomItem("MOODS FOR LONGING", "Subtitle 2", R.drawable.music, "https://open.spotify.com/album/2dzOgAcjyzZv0F267Cr5cV?si=yUgSR-juRqOo9vbTBzezsA&nd=1&dlsi=ff2fef770bd24681"),
        CustomItem("LOFI SONGS", "Subtitle 3", R.drawable.music, "https://open.spotify.com/playlist/5jYQ4O9Ii3tQcSbJMtVrk8?si=3f76cb57532d4718&nd=1&dlsi=6eafc3462ab64de6"),
        CustomItem("STRESS RELIEF", "Subtitle 4", R.drawable.music, "https://open.spotify.com/playlist/37i9dQZF1DWXe9gFZP0gtP?si=h6BDyPhPTg2UU2FYRjdcZA&utm_source=whatsapp")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(customItems) { item ->
            CustomCardItem(
                customItem = item,
                onClick = {
                    handleLinkClick(item.link, navController)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
    }
}

data class CustomItem(val title: String, val subtitle: String, val drawableId: Int, val link: String)

@Composable
fun CustomCardItem(
    customItem: CustomItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(Color(0xFFE1DBD3)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = customItem.drawableId),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = customItem.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = customItem.subtitle, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

private fun handleLinkClick(link: String, navController: NavHostController) {
    // Check if the link is an external link (starts with "http" or "https")
    if (link.startsWith("http") || link.startsWith("https")) {
        // Open external link in a browser
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        navController.context.startActivity(intent)
    } else {
        // Handle internal navigation
        navController.navigate(link)
    }
}
