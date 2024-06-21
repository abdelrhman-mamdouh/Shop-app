package com.example.exclusive.ui.products.view

import com.example.exclusive.data.model.ProductNode


interface OnProductClickListener {
    fun onProductClick(product: ProductNode)
    fun onFavClick(product: ProductNode)
}
