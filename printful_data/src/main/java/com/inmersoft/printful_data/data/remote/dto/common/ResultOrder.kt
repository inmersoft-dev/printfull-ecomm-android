package com.inmersoft.printful_data.data.remote.dto.common

data class ResultOrder(
    val can_change_hold: Boolean,
    val costs: CostsOrder,
    val created: Int,
    val dashboard_url: String,
    val error: Any,
    val errorCode: Int,
    val external_id: Any,
    val gift: Any,
    val has_discontinued_items: Boolean,
    val id: Int,
    val incomplete_items: List<Any>,
    val is_sample: Boolean,
    val items: List<ItemOrder>,
    val needs_approval: Boolean,
    val not_synced: Boolean,
    val notes: Any,
    val packing_slip: Any,
    val recipient: RecipientOrder,
    val retail_costs: RetailCostsOrder,
    val shipments: List<Any>,
    val shipping: String,
    val shipping_service_name: String,
    val status: String,
    val store: Int,
    val updated: Int
)