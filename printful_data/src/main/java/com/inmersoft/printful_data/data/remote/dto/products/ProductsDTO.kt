package com.inmersoft.printful_data.data.remote.dto.products

import com.inmersoft.printful_data.data.remote.dto.common.ProductData
import com.inmersoft.printful_data.domain.model.Products

data class ProductsDTO(
    val code: Int,
    val extra: List<Any>,
    val paging: Paging,
    val result: List<ProductData>
)

fun ProductsDTO.toProducts(): Products {
    return Products(
        paging = paging,
        result = result
    )
}