package com.inmersoft.printful_data.data.remote.dto.country_state

import com.inmersoft.printful_data.data.remote.dto.country_state.Country
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryStatesDTO(
    val code: Int,
    val extra: List<Any>,
    val result: List<Country>
)