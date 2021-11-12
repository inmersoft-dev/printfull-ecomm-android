package com.inmersoft.printful_data.domain.use_case.cart.delete_products_in_cart

import com.inmersoft.printful_data.domain.repository.PrintfulRepository

class DeleteProductsInCartUseCase(
    private val repository: PrintfulRepository
) {
    suspend operator fun invoke(
        variantId: Int
    ) {
        return repository.deleteVariantByIdInCartDB(roomSyncVariantID = variantId)
    }
}