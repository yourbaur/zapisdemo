package com.example.zapiskz.data.vo

data class Service(
    val categoryId: Int,
    val description: String,
    val duration: Int,
    val express: Any,
    val id: Int,
    val name: String,
    val prepaymentAmount: Int,
    val price: Int,
    val priceMax: Int,
    val priceStr: String
)