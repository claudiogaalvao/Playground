package com.claudiogalvaodev.playground.model

import androidx.compose.runtime.Stable

@Stable
data class CartItem(
    val id: Int,
    val name: String,
    val quantity: Int
)