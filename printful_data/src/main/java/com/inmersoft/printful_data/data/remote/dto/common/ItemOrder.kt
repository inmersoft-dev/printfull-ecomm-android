package com.inmersoft.printful_data.data.remote.dto.common

data class ItemOrder(
    val discontinued: Boolean,
    val external_id: Any,
    val external_variant_id: Any,
    val files: List<File>,
    val id: Int,
    val name: String,
    val options: List<Any>,
    val out_of_stock: Boolean,
    val out_of_stock_eu: Boolean,
    val price: String,
    val product: Product,
    val quantity: Int,
    val retail_price: Any,
    val sku: Any,
    val sync_variant_id: Any,
    val variant_id: Int
)