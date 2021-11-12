package com.inmersoft.printful_data.data.repository

import com.inmersoft.printful_data.data.local.dao.CountryStatesDao
import com.inmersoft.printful_data.data.local.dao.FavoriteProductsDao
import com.inmersoft.printful_data.data.local.dao.ProductInCartDao
import com.inmersoft.printful_data.data.local.model.CountryEntity
import com.inmersoft.printful_data.data.local.model.FavoriteProduct
import com.inmersoft.printful_data.data.local.model.ProductInCart
import com.inmersoft.printful_data.data.remote.PrintfulApi
import com.inmersoft.printful_data.data.remote.dto.country_state.CountryStatesDTO
import com.inmersoft.printful_data.data.remote.dto.details.DetailsDTO
import com.inmersoft.printful_data.data.remote.dto.products.ProductsDTO
import com.inmersoft.printful_data.data.remote.dto.store_info.StoreInfoDTO
import com.inmersoft.printful_data.domain.repository.PrintfulRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrintfulRepositoryImpl @Inject constructor(
    private val apiPrintfulApi: PrintfulApi,
    private val productInCartDao: ProductInCartDao,
    private val favoriteProductsDao: FavoriteProductsDao,
    private val countryStatesDao: CountryStatesDao,
) : PrintfulRepository {


    //Get Products From API
    override suspend fun getProducts(limit: Int, offset: Int): ProductsDTO {
        return apiPrintfulApi.getProducts(offset = offset, limit = limit)
    }

    override suspend fun getDetailsById(productID: String): DetailsDTO {
        return apiPrintfulApi.getDetailsById(productID = productID)
    }

    override suspend fun getStoreInfo(): StoreInfoDTO {
        return apiPrintfulApi.getStoreInfo()
    }

    override suspend fun searchProduct(limit: Int, offset: Int, search: String): ProductsDTO {
        return apiPrintfulApi.searchProducts(offset = offset, limit = limit, search = search)
    }

    override suspend fun getCountries(): CountryStatesDTO {
        return apiPrintfulApi.getCountriesInfo()
    }


    //CRUD Products in Cart database
    override suspend fun insertVariantInCartDB(productInCart: ProductInCart) {
        productInCartDao.insert(productInCart = productInCart)
    }

    override suspend fun updateVariantInCartDB(productInCart: ProductInCart) {
        productInCartDao.update(productInCart = productInCart)
    }

    override suspend fun deleteVariantByIdInCartDB(roomSyncVariantID: Int) {
        productInCartDao.delete(variantId = roomSyncVariantID)
    }

    override suspend fun deleteAllDataInChartDB() {
        productInCartDao.deleteAll()
    }

    override fun getAllProductsInCartDB(): Flow<List<ProductInCart>> {
        return productInCartDao.getAllProductsInChart()
    }


    //CRUD Favorites products
    override suspend fun insertFavoriteInDB(productFavorite: FavoriteProduct) {
        favoriteProductsDao.insert(productFavorite)
    }

    override fun getAllFavoritesInDB(): Flow<List<FavoriteProduct>> {
        return favoriteProductsDao.getAllFavoriteProducts()
    }

    override suspend fun deleteFavoriteByIdInDB(productFavoriteId: Int) {
        favoriteProductsDao.delete(productFavoriteId)
    }

    override suspend fun deleteAllFavoriteInDB() {
        favoriteProductsDao.deleteAll()
    }

    override suspend fun insertCountryInDB(countryEntity: CountryEntity) {
        countryStatesDao.insert(countryEntity = countryEntity)
    }

    override suspend fun insertCountryListInDB(countryListEntity: List<CountryEntity>) {
        countryStatesDao.insertAll(countryListEntity)
    }

    override fun getAllCountryInDB(): Flow<List<CountryEntity>> {
        return countryStatesDao.getAllCountryState()
    }

    override suspend fun deleteAllCountryInDB() {
        countryStatesDao.deleteAll()
    }

    override suspend fun getCountriesCount(): Int? {
        return countryStatesDao.getCountriesCount()
    }


}