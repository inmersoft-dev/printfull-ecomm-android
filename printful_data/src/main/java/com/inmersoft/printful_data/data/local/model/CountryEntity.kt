package com.inmersoft.printful_data.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.inmersoft.printful_data.data.remote.dto.country_state.State
import com.squareup.moshi.JsonClass

@Entity(tableName = "country_states")
@JsonClass(generateAdapter = true)
data class CountryEntity(
    val code: String,
    val name: String,
    val states: List<State>?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
