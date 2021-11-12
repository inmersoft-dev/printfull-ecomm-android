package com.inmersoft.printful_data.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inmersoft.printful_data.data.local.model.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryStatesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(countryEntity: CountryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countryListEntity: List<CountryEntity>)

    @Query("DELETE FROM country_states")
    suspend fun deleteAll()

    @Query("SELECT * FROM country_states")
    fun getAllCountryState(): Flow<List<CountryEntity>>

    @Query("SELECT COUNT(code) FROM country_states")
    suspend fun getCountriesCount(): Int?

}
