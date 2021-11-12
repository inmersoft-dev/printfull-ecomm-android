package com.inmersoft.printful_data.domain.use_case.store.get_store_info

import com.inmersoft.printful_data.common.DataResult
import com.inmersoft.printful_data.common.ErrorType
import com.inmersoft.printful_data.common.ResourcesError
import com.inmersoft.printful_data.data.remote.dto.store_info.toStoreInfo
import com.inmersoft.printful_data.domain.model.StoreInfo
import com.inmersoft.printful_data.domain.repository.PrintfulRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetStoreInfoUseCase(
    private val repository: PrintfulRepository
) {
    operator fun invoke(
    ): Flow<DataResult<StoreInfo>> = flow {
        try {
            emit(DataResult.Loading())
            val storeInfo = repository.getStoreInfo().toStoreInfo()
            emit(DataResult.Success(storeInfo))
        }
        catch (e: HttpException) {
            emit(DataResult.Error(e.message?.let {
                ResourcesError(
                    ErrorType.HTTP_ERROR,
                    message = it
                )
            }))
        } catch (e: IOException) {
            emit(
                DataResult.Error(
                    ResourcesError(
                        ErrorType.IO_ERROR,
                        message = e.message ?: "UNKNOW"
                    )
                )
            )
        } catch (e: Exception) {
            emit(
                DataResult.Error(
                    ResourcesError(
                        ErrorType.UNKNOW_ERROR,
                        message = e.message ?: "UNKNOW"
                    )
                )
            )
        }
    }
}