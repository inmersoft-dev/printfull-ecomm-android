package com.inmersoft.printful_data.data.local.converters

import androidx.room.TypeConverter
import com.inmersoft.printful_data.data.remote.dto.country_state.State
import com.inmersoft.printful_data.data.remote.dto.products.ProductsDTO
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {
    val moshi = Moshi.Builder().build()

    @TypeConverter
    fun stringListToString(list: List<String>?): String {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(type)
        return adapter.toJson(list)
    }

    @TypeConverter
    fun stringToStringList(json: String): List<String>? {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(type)
        return adapter.fromJson(json)
    }

    @TypeConverter
    fun stateListToString(list: List<State>?): String {
        val type = Types.newParameterizedType(List::class.java, State::class.java)
        val adapter: JsonAdapter<List<State>> = moshi.adapter(type)
        return adapter.toJson(list)
    }

    @TypeConverter
    fun stringToStateList(json: String): List<State>? {
        val type = Types.newParameterizedType(List::class.java, State::class.java)
        val adapter: JsonAdapter<List<State>> = moshi.adapter(type)
        return adapter.fromJson(json)
    }

    @TypeConverter
    fun productDTOToString(productsDTO: ProductsDTO): String {
        val type = Types.newParameterizedType(List::class.java, ProductsDTO::class.java)
        val adapter: JsonAdapter<ProductsDTO> = moshi.adapter(type)
        return adapter.toJson(productsDTO)
    }

    @TypeConverter
    fun stringToProductsDTO(json: String): ProductsDTO? {
        val type = Types.newParameterizedType(String::class.java, ProductsDTO::class.java)
        val adapter: JsonAdapter<ProductsDTO> = moshi.adapter(type)
        return adapter.fromJson(json)
    }
}