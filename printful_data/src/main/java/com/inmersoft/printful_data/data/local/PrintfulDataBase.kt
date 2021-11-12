package com.inmersoft.printful_data.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.inmersoft.printful_data.data.local.converters.Converters
import com.inmersoft.printful_data.data.local.dao.CountryStatesDao
import com.inmersoft.printful_data.data.local.dao.FavoriteProductsDao
import com.inmersoft.printful_data.data.local.dao.ProductInCartDao
import com.inmersoft.printful_data.data.local.model.CountryEntity
import com.inmersoft.printful_data.data.local.model.FavoriteProduct
import com.inmersoft.printful_data.data.local.model.ProductInCart

@Database(
    entities = [ProductInCart::class, FavoriteProduct::class, CountryEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class PrintfulDataBase : RoomDatabase() {

    abstract fun productsInCartDao(): ProductInCartDao
    abstract fun favoriteProductsDao(): FavoriteProductsDao
    abstract fun countryStatesDao(): CountryStatesDao

    companion object {
        @Volatile
        private var INSTANCE: PrintfulDataBase? = null

        fun getDatabase(context: Context): PrintfulDataBase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): PrintfulDataBase {
            return Room.databaseBuilder(context, PrintfulDataBase::class.java, "ecommerce-chart.db")
                .build()
        }
    }

}