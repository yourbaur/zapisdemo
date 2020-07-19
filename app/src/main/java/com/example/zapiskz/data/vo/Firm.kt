package com.example.zapiskz.data.vo

data class Firm(
    val address: String,
    val avatarUrl: String,
    val averageRating: Int,
    val category: String,
    val checkRating: Int,
    val cityName: String,
    val description: String,
    val id: Int,
    val instagramProfile: String,
    val isClientSurnameRequired: Boolean,
    val isExpress: Boolean,
    val isMastersHidden: Boolean,
    val isPromoted: Boolean,
    val name: String,
    val phoneNumbers: List<String>,
    val pictures: List<String>,
    val prepaymentCashbackAmount: String,
    val prepaymentCashbackInfo: String,
    val reviewCount: Int,
    val todayReservationsCount: Any,
    val type: String,
    val urlKey: String,
    val videoUrl: String,
    val workEndTime: String,
    val workStartTime: String
)