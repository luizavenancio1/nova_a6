package com.example.atividadehj.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.atividadehj.storage.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    suspend fun getAll(): List<Product>

    @Insert
    suspend fun insert(product: Product)
}
