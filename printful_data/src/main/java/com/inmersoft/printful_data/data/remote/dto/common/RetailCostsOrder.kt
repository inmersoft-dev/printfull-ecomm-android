package com.inmersoft.printful_data.data.remote.dto.common

data class RetailCostsOrder(
    val currency: String,
    val discount: Any,
    val shipping: Any,
    val subtotal: Any,
    val tax: Any,
    val total: Any,
    val vat: Any
)