package com.inmersoft.printful_data.di

import android.content.Context
import com.inmersoft.printful_data.common.Constants
import com.inmersoft.printful_data.data.local.PrintfulDataBase
import com.inmersoft.printful_data.data.local.dao.CountryStatesDao
import com.inmersoft.printful_data.data.local.dao.FavoriteProductsDao
import com.inmersoft.printful_data.data.local.dao.ProductInCartDao
import com.inmersoft.printful_data.data.remote.PrintfulApi
import com.inmersoft.printful_data.data.repository.PrintfulRepositoryImpl
import com.inmersoft.printful_data.domain.repository.PrintfulRepository
import com.inmersoft.printful_data.domain.use_case.PrintfulUseCase
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
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModulesDi {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().addLast(
        KotlinJsonAdapterFactory()
    ).build()

    @Provides
    @Singleton
    fun providePrintfulRepository(
        api: PrintfulApi,
        productInCartDao: ProductInCartDao,
        favoriteProductsDao: FavoriteProductsDao,
        countryStatesDao: CountryStatesDao
    ): PrintfulRepository {
        return PrintfulRepositoryImpl(
            apiPrintfulApi = api,
            productInCartDao = productInCartDao,
            favoriteProductsDao = favoriteProductsDao,
            countryStatesDao = countryStatesDao
        )
    }

    @Provides
    @Singleton
    fun providePrintfulApiService(): PrintfulApi {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val defaultHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .addHeader(
                        "Authorization",
                        value = "Basic ${Constants.API_KEY}"
                    )
                    .build()
                chain.proceed(request)
            }).build()

        return Retrofit.Builder()
            .baseUrl(PrintfulApi.API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(defaultHttpClient)
            .build()
            .create(PrintfulApi::class.java)
    }

    @Provides
    @Singleton
    fun providePrintfulUseCases(repository: PrintfulRepository): PrintfulUseCase {
        return PrintfulUseCase(
            getDetailsUseCase = GetDetailsUseCase(repository = repository),
            getProductsUseCase = GetProductsUseCase(repository = repository),
            getStoreInfoUseCase = GetStoreInfoUseCase(repository = repository),
            searchProductsUseCase = SearchProductsUseCase(repository = repository),
            addToCartUseCase = AddToCartUseCase(repository = repository),
            getProductsInCartUseCase = GetProductsInCartUseCase(repository = repository),
            deleteProductsInCartUseCase = DeleteProductsInCartUseCase(repository = repository),
            updateProductsInCartUseCase = UpdateProductsInCartUseCase(repository = repository),
            addFavoriteProductUseCase = AddFavoriteProductUseCase(repository = repository),
            deleteFavoriteProductUseCase = DeleteFavoriteProductUseCase(repository = repository),
            deleteAllFavoriteProductUseCase = DeleteAllFavoriteProductUseCase(repository = repository),
            getFavoriteProductsUseCase = GetFavoriteProductsUseCase(repository = repository),
            onUpdateCountriesFromApiUseCase = OnUpdateCountriesFromApiUseCase(repository = repository),
            getCountriesFromDatabaseUseCase = GetCountriesFromDatabaseUseCase(repository = repository),
            getCountriesCountFromDatabaseUseCase = GetCountriesCountFromDatabaseUseCase(repository = repository),
        )
    }


    @Singleton
    @Provides
    fun providePrintFulDatabase(@ApplicationContext appContext: Context) =
        PrintfulDataBase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideProductsInCartDao(database: PrintfulDataBase): ProductInCartDao =
        database.productsInCartDao()

    @Singleton
    @Provides
    fun provideFavoriteProductsDao(database: PrintfulDataBase): FavoriteProductsDao =
        database.favoriteProductsDao()


    @Singleton
    @Provides
    fun provideCounryStatesDao(database: PrintfulDataBase): CountryStatesDao =
        database.countryStatesDao()
}