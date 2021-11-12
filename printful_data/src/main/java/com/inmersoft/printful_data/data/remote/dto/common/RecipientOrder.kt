package com.inmersoft.printful_data.data.remote.dto.common

data class RecipientOrder(
    val address1: String,
    val address2: Any,
    val city: String,
    val company: Any,
    val country_code: String,
    val country_name: String,
    val email: Any,
    val name: String,
    val phone: Any,
    val state_code: String,
    val state_name: String,
    val zip: String
)