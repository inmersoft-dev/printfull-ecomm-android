package com.inmersoft.printful_data.data.remote.dto.country_state

import com.inmersoft.printful_data.data.local.model.CountryEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    val code: String,
    val name: String,
    val states: List<State>?
)

fun Country.toCountryEntity(): CountryEntity {
    return CountryEntity(
        code = code,
        name = name,
        states = states
    )

}
