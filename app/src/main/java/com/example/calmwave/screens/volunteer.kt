package com.example.calmwave.screens

//import androidx.compose.material3.LocalContext
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@Composable
fun Volunteer(navController: NavHostController) {
    var isWebViewVisible by remember { mutableStateOf(true) }

    if (isWebViewVisible) {
        WebViewContentVolunteer("https://www.volunteermatch.org/") {
            isWebViewVisible = false
        }
    }
}

@Composable
fun WebViewContentVolunteer(url: String, onClose: () -> Unit) {
    val context = LocalContext.current
    val webView = remember {
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }

    // Ensure that WebView is disposed when the composable is destroyed
    DisposableEffect(webView) {
        onDispose {
            webView.destroy()
        }
    }

    AndroidView(
        factory = { webView },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { view ->
        // This block intentionally left blank
    }

    // You can remove the button, as the WebView starts automatically
}

