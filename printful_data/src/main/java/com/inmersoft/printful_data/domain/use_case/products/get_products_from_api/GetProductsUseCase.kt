package com.inmersoft.printful_data.domain.use_case.products.get_products_from_api

import com.inmersoft.printful_data.common.Constants
import com.inmersoft.printful_data.common.DataResult
import com.inmersoft.printful_data.common.ErrorType
import com.inmersoft.printful_data.common.ResourcesError
import com.inmersoft.printful_data.data.remote.dto.products.toProducts
import com.inmersoft.printful_data.domain.model.Products
import com.inmersoft.printful_data.domain.repository.PrintfulRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetProductsUseCase(
    private val repository: PrintfulRepository
) {
    operator fun invoke(
        offset: Int = 0,
        limit: Int = Constants.MAX_PRODUCT_LIMIT
    ): Flow<DataResult<Products>> = flow {
        try {
            emit(DataResult.Loading())
            val products =
                repository.getProducts(offset = offset, limit = limit).toProducts()
            emit(DataResult.Success(products))
        } catch (e: HttpException) {
            emit(DataResult.Error(e.message?.let { ResourcesError(ErrorType.HTTP_ERROR, message = it) }))
        } catch (e: IOException) {
            emit(DataResult.Error(e.message?.let { ResourcesError(ErrorType.IO_ERROR, message = it) }))
        } catch (e: Exception) {
            emit(DataResult.Error(e.message?.let { ResourcesError(ErrorType.UNKNOW_ERROR, message = it) }))
        }
    }

}