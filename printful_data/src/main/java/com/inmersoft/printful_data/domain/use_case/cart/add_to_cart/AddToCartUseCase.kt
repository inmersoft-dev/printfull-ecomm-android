package com.inmersoft.printful_data.domain.use_case.cart.add_to_cart

import com.inmersoft.printful_data.data.local.model.ProductInCart
import com.inmersoft.printful_data.domain.repository.PrintfulRepository

class AddToCartUseCase(
    private val repository: PrintfulRepository
) {
    suspend operator fun invoke(
        syncVariant: ProductInCart
    ) {
        repository.insertVariantInCartDB(syncVariant)
    }
}