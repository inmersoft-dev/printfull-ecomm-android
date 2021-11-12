package com.inmersoft.printful_data.domain.use_case.favorites.delete_favorite_products

import com.inmersoft.printful_data.domain.repository.PrintfulRepository

class DeleteFavoriteProductUseCase(
    private val repository: PrintfulRepository
) {
    suspend operator fun invoke(
        favoriteId: Int
    ) {
        repository.deleteFavoriteByIdInDB(favoriteId)
    }
}