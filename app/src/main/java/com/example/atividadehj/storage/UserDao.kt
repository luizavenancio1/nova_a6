package com.example.atividadehj.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.atividadehj.storage.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insert(user: User)
}
