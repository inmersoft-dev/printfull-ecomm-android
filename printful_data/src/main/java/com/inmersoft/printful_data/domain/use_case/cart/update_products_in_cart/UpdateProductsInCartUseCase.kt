package com.inmersoft.printful_data.domain.use_case.cart.update_products_in_cart

import com.inmersoft.printful_data.data.local.model.ProductInCart
import com.inmersoft.printful_data.domain.repository.PrintfulRepository

class UpdateProductsInCartUseCase(
    private val repository: PrintfulRepository
) {
    suspend operator fun invoke(
        productInCart: ProductInCart
    ) {
        return repository.updateVariantInCartDB(productInCart = productInCart)
    }
}