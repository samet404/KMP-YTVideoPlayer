package org.videplayer.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.multiplatform.webview.web.WebContent
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            WebViewSample()
        }
    }
}

@Composable
internal fun WebViewSample() {
    MaterialTheme {
        val url = remember { mutableStateOf<String>("https://notfound404.dev") }
        val webViewState = remember {
            mutableStateOf(
                WebViewState(
                    webContent = WebContent.Data("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/7UIHl0oJEpg?si=6lGL2pyTPsalgK4Y\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>")
                )
            )
        }

        Column(Modifier.fillMaxSize()) {
            val text = webViewState.let {
                "${webViewState.value.pageTitle ?: ""} ${webViewState.value.loadingState} ${webViewState.value.lastLoadedUrl ?: ""}"
            }
            Text(text)
            WebView(
                state = webViewState.value,
                modifier = Modifier.fillMaxSize()
            )
        }

    }
}