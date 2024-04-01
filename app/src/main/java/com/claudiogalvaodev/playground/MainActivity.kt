package com.claudiogalvaodev.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.claudiogalvaodev.playground.model.CartItem
import com.claudiogalvaodev.playground.model.CartUiState
import com.claudiogalvaodev.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // val viewModel: MainViewModel = viewModel()
            // val cartUiState by viewModel.cartUiState.observeAsState()

            PlaygroundTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CartItem()
                }
            }
        }
    }
}

@Composable
fun CartItem() {
    var quantity = 0
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { quantity-- },
        ) {
            Text(text = "-")
        }
        Text(
            text = "$quantity items selected.",
            fontSize = 20.sp
        )
        Button(onClick = { quantity++ }) {
            Text(text = "+")
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF)
@Composable
fun GreetingPreview() {
    PlaygroundTheme {
        CartItem()
    }
}