package com.inmersoft.printful_data.data.remote.dto.orders

import com.inmersoft.printful_data.data.remote.dto.common.ResultOrder

data class OrderDTO(
    val code: Int,
    val extra: List<Any>,
    val result: ResultOrder
)