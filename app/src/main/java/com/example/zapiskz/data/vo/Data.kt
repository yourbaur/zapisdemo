package com.example.zapiskz.data.vo

data class Data(
    val categories: List<Category>,
    val firm: Firm,
    val instagram: Any,
    val isOnline: Boolean,
    val location: Location,
    val masters: List<Master>,
    val services: List<Service>
)