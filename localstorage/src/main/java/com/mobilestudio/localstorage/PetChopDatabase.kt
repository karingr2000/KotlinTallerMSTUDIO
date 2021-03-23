package com.mobilestudio.localstorage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobilestudio.localstorage.dao.ProductsDao
import com.mobilestudio.localstorage.entities.Product


@Database(entities = [Product::class], version = 1)
abstract class PetChopDatabase : RoomDatabase() {

    abstract fun productDao(): ProductsDao

    companion object {
        @Volatile
        private var dbInstance: PetChopDatabase? = null
        fun getInstance(context: Context): PetChopDatabase? {
            return dbInstance ?: synchronized(this) {
                dbInstance = Room.databaseBuilder(
                    context,
                    PetChopDatabase::class.java,
                    "PetChopDB"
                ).build()
                return dbInstance
            }
        }
    }

}