package com.example.exclusive.ui.products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exclusive.data.remote.UiState
import com.example.exclusive.model.ProductNode
import com.example.exclusive.ui.products.repository.ProductsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductsRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ProductNode>>>(UiState.Idle)
    val uiState: StateFlow<UiState<List<ProductNode>>> get() = _uiState

    fun fetchProducts(vendor: String) {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val products = productRepository.getProducts(vendor)
                _uiState.value = UiState.Success(products)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e)
            }
        }
    }
}