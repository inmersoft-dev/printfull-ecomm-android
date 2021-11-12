package com.inmersoft.printful_data.domain.repository

import com.inmersoft.printful_data.common.Constants
import com.inmersoft.printful_data.data.local.model.CountryEntity
import com.inmersoft.printful_data.data.local.model.FavoriteProduct
import com.inmersoft.printful_data.data.local.model.ProductInCart
import com.inmersoft.printful_data.data.remote.dto.country_state.CountryStatesDTO
import com.inmersoft.printful_data.data.remote.dto.details.DetailsDTO
import com.inmersoft.printful_data.data.remote.dto.products.ProductsDTO
import com.inmersoft.printful_data.data.remote.dto.store_info.StoreInfoDTO
import kotlinx.coroutines.flow.Flow

interface PrintfulRepository {

    //Get Products From API
    suspend fun getProducts(limit: Int = Constants.MAX_PRODUCT_LIMIT, offset: Int = 0): ProductsDTO

    //Get Details From API
    suspend fun getDetailsById(productID: String): DetailsDTO

    //Get Store Info From API
    suspend fun getStoreInfo(): StoreInfoDTO

    //Search Product in API
    suspend fun searchProduct(limit: Int, offset: Int, search: String): ProductsDTO

    //Get Country From API
    suspend fun getCountries(): CountryStatesDTO

    //CRUD Cart in the Database
    suspend fun insertVariantInCartDB(productInCart: ProductInCart)
    suspend fun updateVariantInCartDB(productInCart: ProductInCart)
    suspend fun deleteVariantByIdInCartDB(roomSyncVariantID: Int)
    suspend fun deleteAllDataInChartDB()
    fun getAllProductsInCartDB(): Flow<List<ProductInCart>>

    //CRUD favorite products in Database
    suspend fun insertFavoriteInDB(productFavorite: FavoriteProduct)
    fun getAllFavoritesInDB(): Flow<List<FavoriteProduct>>
    suspend fun deleteFavoriteByIdInDB(productFavoriteId: Int)

    suspend fun deleteAllFavoriteInDB()

    //CRUD country and states in Database
    suspend fun insertCountryInDB(countryEntity: CountryEntity)
    suspend fun insertCountryListInDB(countryListEntity: List<CountryEntity>)
    fun getAllCountryInDB(): Flow<List<CountryEntity>>
    suspend fun deleteAllCountryInDB()
    suspend fun getCountriesCount(): Int?

}
