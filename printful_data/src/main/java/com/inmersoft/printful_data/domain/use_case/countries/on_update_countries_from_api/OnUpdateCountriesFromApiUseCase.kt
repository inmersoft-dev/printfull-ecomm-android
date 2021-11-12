package com.inmersoft.printful_data.domain.use_case.countries.on_update_countries_from_api

import android.util.Log
import com.inmersoft.printful_data.common.DataResult
import com.inmersoft.printful_data.common.ErrorType
import com.inmersoft.printful_data.common.ResourcesError
import com.inmersoft.printful_data.data.remote.dto.country_state.Country
import com.inmersoft.printful_data.data.remote.dto.country_state.toCountryEntity
import com.inmersoft.printful_data.domain.repository.PrintfulRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class OnUpdateCountriesFromApiUseCase(
    private val repository: PrintfulRepository
) {
    operator fun invoke(
    ): Flow<DataResult<List<Country>>> = flow {
        try {
            emit(DataResult.Loading())
            val countries = repository.getCountries().result
            if (countries.isNotEmpty()) {
                repository.insertCountryListInDB(countries.map { it.toCountryEntity() })
            }
            emit(DataResult.Success(countries))
        } catch (e: HttpException) {
            Log.d(
                "TAG-PRODUCT-VIEWMODEL",
                "ERROR HTTP OnUpdateCountriesFromApiUseCase: ${e.message()}"
            )
            emit(DataResult.Error(e.message?.let {
                ResourcesError(
                    ErrorType.HTTP_ERROR,
                    message = it
                )
            }))
        } catch (e: IOException) {
            Log.d(
                "TAG-PRODUCT-VIEWMODEL",
                "ERROR IO OnUpdateCountriesFromApiUseCase: ${e.message ?: ""}"
            )
            emit(DataResult.Error(e.message?.let {
                ResourcesError(
                    ErrorType.IO_ERROR,
                    message = it
                )
            }))
        } catch (e: Exception) {
            Log.d(
                "TAG-PRODUCT-VIEWMODEL",
                "ERROR EXCEPTION OnUpdateCountriesFromApiUseCase: ${e.message ?: ""}"
            )
            emit(DataResult.Error(e.message?.let {
                ResourcesError(
                    ErrorType.UNKNOW_ERROR,
                    message = it
                )
            }))
        }
    }

}