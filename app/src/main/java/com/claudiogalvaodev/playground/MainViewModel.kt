package com.claudiogalvaodev.playground

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.claudiogalvaodev.playground.model.CartItem

class MainViewModel: ViewModel() {

    private val _cartUiState = MutableLiveData<CartUiState>()
    val cartUiState: LiveData<CartUiState> = _cartUiState

//    private val _cartUiStateFlow = MutableStateFlow<CartUiState>(CartUiState(emptyList()))
//    val cartUiStateFlow: StateFlow<CartUiState> = _cartUiStateFlow

    init {
        _cartUiState.value = CartUiState(
            items = listOf(
                CartItem(1, "coffee", 0),
                CartItem(2, "tea", 0),
                CartItem(3, "espresso", 0)
            )
        )
//        _cartUiStateFlow.value = CartUiState(
//            items = listOf(
//                CartItem(1, "coffee", 0),
//                CartItem(2, "tea", 0),
//                CartItem(3, "espresso", 0)
//            )
//        )
    }

    fun incrementCartItemCount(itemId: Int) {
        _cartUiState.value = _cartUiState.value?.copy(
            items = _cartUiState.value?.items?.map {
                if (it.id == itemId) {
                    it.copy(quantity = it.quantity + 1)
                } else {
                    it
                }
            } ?: emptyList()
        )
//        _cartUiStateFlow.value = _cartUiStateFlow.value.copy(
//            items = _cartUiStateFlow.value.items.map {
//                if (it.id == itemId) {
//                    it.copy(quantity = it.quantity + 1)
//                } else {
//                    it
//                }
//            }
//        )
    }

    fun decrementCartItemCount(itemId: Int) {
        _cartUiState.value = _cartUiState.value?.copy(
            items = _cartUiState.value?.items?.map {
                if (it.id == itemId) {
                    it.copy(quantity = it.quantity - 1)
                } else {
                    it
                }
            } ?: emptyList()
        )
//        _cartUiStateFlow.value = _cartUiStateFlow.value.copy(
//            items = _cartUiStateFlow.value.items.map {
//                if (it.id == itemId) {
//                    it.copy(quantity = it.quantity - 1)
//                } else {
//                    it
//                }
//            }
//        )
    }


}