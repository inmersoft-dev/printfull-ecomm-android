package com.inmersoft.printful_data.domain.use_case

import com.inmersoft.printful_data.domain.use_case.cart.add_to_cart.AddToCartUseCase
import com.inmersoft.printful_data.domain.use_case.cart.delete_products_in_cart.DeleteProductsInCartUseCase
import com.inmersoft.printful_data.domain.use_case.cart.get_products_in_cart.GetProductsInCartUseCase
import com.inmersoft.printful_data.domain.use_case.cart.update_products_in_cart.UpdateProductsInCartUseCase
import com.inmersoft.printful_data.domain.use_case.countries.get_countries_count_from_database.GetCountriesCountFromDatabaseUseCase
import com.inmersoft.printful_data.domain.use_case.countries.get_countries_from_database.GetCountriesFromDatabaseUseCase
import com.inmersoft.printful_data.domain.use_case.countries.on_update_countries_from_api.OnUpdateCountriesFromApiUseCase
import com.inmersoft.printful_data.domain.use_case.details.get_details.GetDetailsUseCase
import com.inmersoft.printful_data.domain.use_case.favorites.add_favorite_products.AddFavoriteProductUseCase
import com.inmersoft.printful_data.domain.use_case.favorites.delete_all_favorite_products.DeleteAllFavoriteProductUseCase
import com.inmersoft.printful_data.domain.use_case.favorites.delete_favorite_products.DeleteFavoriteProductUseCase
import com.inmersoft.printful_data.domain.use_case.favorites.get_favorite_products.GetFavoriteProductsUseCase
import com.inmersoft.printful_data.domain.use_case.products.get_products_from_api.GetProductsUseCase
import com.inmersoft.printful_data.domain.use_case.products.search_products.SearchProductsUseCase
import com.inmersoft.printful_data.domain.use_case.store.get_store_info.GetStoreInfoUseCase

data class PrintfulUseCase(
    val getProductsUseCase: GetProductsUseCase,
    val getDetailsUseCase: GetDetailsUseCase,
    val searchProductsUseCase: SearchProductsUseCase,
    val getStoreInfoUseCase: GetStoreInfoUseCase,
    val addToCartUseCase: AddToCartUseCase,
    val getProductsInCartUseCase: GetProductsInCartUseCase,
    val deleteProductsInCartUseCase: DeleteProductsInCartUseCase,
    val updateProductsInCartUseCase: UpdateProductsInCartUseCase,
    val addFavoriteProductUseCase: AddFavoriteProductUseCase,
    val deleteFavoriteProductUseCase: DeleteFavoriteProductUseCase,
    val deleteAllFavoriteProductUseCase: DeleteAllFavoriteProductUseCase,
    val getFavoriteProductsUseCase: GetFavoriteProductsUseCase,
    val onUpdateCountriesFromApiUseCase: OnUpdateCountriesFromApiUseCase,
    val getCountriesFromDatabaseUseCase: GetCountriesFromDatabaseUseCase,
    val getCountriesCountFromDatabaseUseCase: GetCountriesCountFromDatabaseUseCase
)
