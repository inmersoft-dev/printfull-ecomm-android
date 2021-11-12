package com.inmersoft.printful_data.domain.use_case.countries.get_countries_count_from_database

import com.inmersoft.printful_data.domain.repository.PrintfulRepository

class GetCountriesCountFromDatabaseUseCase(
    private val repository: PrintfulRepository
) {
    suspend operator fun invoke(
    ): Int? {
        return repository.getCountriesCount()
    }
}