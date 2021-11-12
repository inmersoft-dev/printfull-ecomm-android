package com.inmersoft.printful_data.domain.model

import com.inmersoft.printful_data.data.remote.dto.common.ProductData
import com.inmersoft.printful_data.data.remote.dto.products.Paging

data class Products(
    val paging: Paging,
    val result: List<ProductData>
)