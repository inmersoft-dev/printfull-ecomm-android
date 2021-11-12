package com.inmersoft.printful_data.domain.use_case.favorites.add_favorite_products

import com.inmersoft.printful_data.data.local.model.FavoriteProduct
import com.inmersoft.printful_data.domain.repository.PrintfulRepository

class AddFavoriteProductUseCase(
    private val repository: PrintfulRepository
) {
    suspend operator fun invoke(
        favorite: FavoriteProduct
    ) {
        repository.insertFavoriteInDB(favorite)
    }
}