package com.example.demo.app.core.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.demo.app.core.data.db.entity.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user INNER JOIN user_picture ON user.id = user_picture.user_id")
    suspend fun getUsers(): List<UserWithThumbnail>

    @Query(
        """
        SELECT * 
        FROM user INNER JOIN user_picture ON user.id = user_picture.user_id
                  INNER JOIN address ON user.address_id = address.id
        WHERE user.id = :id
    """
    )
    suspend fun getFullUser(id: String): FullUser

    @Insert
    suspend fun insertAddress(address: Address)

    @Insert
    suspend fun insertUser(user: User)

    @Insert
    suspend fun insertUserPicture(userPicture: UserPicture)
}