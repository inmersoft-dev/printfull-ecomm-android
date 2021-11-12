package com.inmersoft.printful_data.domain.use_case.cart.get_products_in_cart

import com.inmersoft.printful_data.data.local.model.ProductInCart
import com.inmersoft.printful_data.domain.repository.PrintfulRepository
import kotlinx.coroutines.flow.Flow

class GetProductsInCartUseCase(
    private val repository: PrintfulRepository
) {
    operator fun invoke(
    ): Flow<List<ProductInCart>> {
        return repository.getAllProductsInCartDB()
    }
}