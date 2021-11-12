package com.inmersoft.printful_data.data.remote.dto.store_info

import com.inmersoft.printful_data.data.remote.dto.store_info.PackingSlip

data class StoreResult(
    val billing_address: Any,
    val created: Int,
    val currency: String,
    val id: Int,
    val name: String,
    val packing_slip: PackingSlip,
    val payment_card: Any,
    val return_address: Any,
    val type: String,
    val website: String
)