package com.inmersoft.printful_data.domain.use_case.favorites.get_favorite_products

import com.inmersoft.printful_data.data.local.model.FavoriteProduct
import com.inmersoft.printful_data.domain.repository.PrintfulRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteProductsUseCase(
    private val repository: PrintfulRepository
) {
    operator fun invoke(
    ): Flow<List<FavoriteProduct>> {
        return repository.getAllFavoritesInDB()
    }
}