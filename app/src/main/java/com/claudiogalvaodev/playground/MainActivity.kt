package com.claudiogalvaodev.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.claudiogalvaodev.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = viewModel()
             val cartUiState by viewModel.cartUiState.observeAsState()
//            val cartUiState by viewModel.cartUiStateFlow.collectAsState()

            PlaygroundTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StatelessCart(
                        cartUiState = cartUiState ?: CartUiState(emptyList()),
                        onDecrement = { id -> viewModel.decrementCartItemCount(id) },
                        onIncrement = { id -> viewModel.incrementCartItemCount(id) }
                    )
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
            text = "$quantity coffees",
            fontSize = 20.sp
        )
        Button(onClick = { quantity++ }) {
            Text(text = "+")
        }
    }
}

@Composable
fun CartItem(
    name: String,
    quantity: Int,
    onDecrement: () -> Unit,
    onIncrement: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onDecrement,
        ) {
            Text(text = "-")
        }
        Text(
            text = "$quantity cups of $name",
            fontSize = 20.sp
        )
        Button(onClick = onIncrement) {
            Text(text = "+")
        }
    }
}
//
//@Composable
//fun StatefullCart() {
//    var coffeeQuantity by remember {
//        mutableStateOf(0)
//    }
//    var juiceQuantity by remember {
//        mutableStateOf(0)
//    }
//    var teaQuantity by remember {
//        mutableStateOf(0)
//    }
//    Column {
//        CartItem(
//            name = "coffe",
//            quantity = coffeeQuantity,
//            onDecrement = { coffeeQuantity-- },
//            onIncrement = { coffeeQuantity++ }
//        )
//        CartItem(
//            name = "juice",
//            quantity = juiceQuantity,
//            onDecrement = { juiceQuantity-- },
//            onIncrement = { juiceQuantity++ }
//        )
//        CartItem(
//            name = "tea",
//            quantity = teaQuantity,
//            onDecrement = { teaQuantity-- },
//            onIncrement = { teaQuantity++ }
//        )
//    }
//}

@Composable
fun StatelessCart(
    cartUiState: CartUiState,
    onDecrement: (id: Int) -> Unit,
    onIncrement: (id: Int) -> Unit
) {
    Column {
        LazyColumn {
            items(
                items = cartUiState.items,
                key = { item -> item.id }
            ) { item ->
                CartItem(
                    name = item.name,
                    quantity = item.quantity,
                    onDecrement = { onDecrement(item.id) },
                    onIncrement = { onIncrement(item.id) }
                )
            }
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