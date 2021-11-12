package com.inmersoft.printful_data.data.remote.dto.common

data class CostsOrder(
    val additional_fee: String,
    val currency: String,
    val digitization: String,
    val discount: String,
    val fulfillment_fee: String,
    val shipping: String,
    val subtotal: String,
    val tax: String,
    val total: String,
    val vat: String
)