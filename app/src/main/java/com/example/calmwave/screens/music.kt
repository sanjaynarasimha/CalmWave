
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.calmwave.R

@Composable
fun Music(navController: NavHostController) {

    val buttonData = listOf(
        ButtonData("Button 1", "https://www.volunteermatch.org/", R.drawable.music),
        ButtonData("Button 2", "https://open.spotify.com/playlist/37i9dQZF1DWXe9gFZP0gtP?si=MTj7G743T4e8hD24xNVFcg&nd=1&dlsi=6158da4553da471c", R.drawable.music),
        ButtonData("Button 3", "https://open.spotify.com/album/2dzOgAcjyzZv0F267Cr5cV?si=yUgSR-juRqOo9vbTBzezsA&nd=1&dlsi=ff2fef770bd24681", R.drawable.music),
        ButtonData("Button 4", "https://www.example.com/3", R.drawable.music)
    )

    val openUrlLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { }

    var selectedButtonIndex by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        buttonData.forEachIndexed { index, button ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Image(
                    painter = painterResource(id = button.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .width(1000.dp)
                        .clickable {
                            selectedButtonIndex = index
                        }
                )
            }
        }
    }

    if (selectedButtonIndex != -1) {
        WebViewContentMusic(buttonData[selectedButtonIndex].url) {
            selectedButtonIndex = -1
        }
    }
}


data class ButtonData(val name: String, val url: String, val imageRes: Int)

@Composable
fun WebViewContentMusic(url: String, onClose: () -> Unit) {
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

    // Add a button to close the WebView
    Button(
        onClick = onClose,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(30.dp))
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            Color.LightGray
        ),
    ) {
        Text(
            text = "Close WebView",
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}
