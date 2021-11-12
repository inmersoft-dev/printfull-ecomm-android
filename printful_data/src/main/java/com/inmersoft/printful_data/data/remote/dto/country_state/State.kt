package com.inmersoft.printful_data.data.remote.dto.country_state

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class State(
    val code: String,
    val name: String
)