package com.example.zapiskz.data.vo

data class Master(
    val avatarUrl: String,
    val capacity: Any,
    val experience: String,
    val id: Int,
    val isRoom: Boolean,
    val name: String,
    val profession: String,
    val rating: Int,
    val serviceIds: List<Int>,
    val surname: String
)