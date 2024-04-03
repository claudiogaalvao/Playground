package com.claudiogalvaodev.playground

import androidx.compose.runtime.Stable
import com.claudiogalvaodev.playground.model.CartItem

@Stable
data class CartUiState(
    val items: List<CartItem>
)
