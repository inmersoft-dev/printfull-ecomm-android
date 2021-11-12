package com.inmersoft.printful_data.domain.use_case.favorites.delete_all_favorite_products

import com.inmersoft.printful_data.domain.repository.PrintfulRepository

class DeleteAllFavoriteProductUseCase(
    private val repository: PrintfulRepository
) {
    suspend operator fun invoke() {
        repository.deleteAllFavoriteInDB()
    }
}