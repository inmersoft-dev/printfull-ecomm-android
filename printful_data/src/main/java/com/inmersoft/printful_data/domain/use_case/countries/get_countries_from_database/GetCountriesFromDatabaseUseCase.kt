package com.inmersoft.printful_data.domain.use_case.countries.get_countries_from_database

import com.inmersoft.printful_data.data.local.model.CountryEntity
import com.inmersoft.printful_data.domain.repository.PrintfulRepository
import kotlinx.coroutines.flow.Flow

class GetCountriesFromDatabaseUseCase(
    private val repository: PrintfulRepository
) {
    operator fun invoke(
    ): Flow<List<CountryEntity>> {
        return repository.getAllCountryInDB()
    }
}