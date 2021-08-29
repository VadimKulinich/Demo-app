package com.example.demo.app.core.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.demo.app.core.data.db.entity.*
import com.example.demo.app.core.data.model.UserPictureType
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query(
        """
        SELECT * 
        FROM user INNER JOIN user_picture ON user.u_id = user_picture.user_id
        INNER JOIN address ON user.address_id = address.a_id
        WHERE user_picture.type = :type
        ORDER BY update_time DESC
    """
    )
    fun observeUsers(@UserPictureType type: Int): Flow<List<UserWithPicture>>

    @Query(
        """
        SELECT * 
        FROM user INNER JOIN user_picture ON user.u_id = user_picture.user_id
                  INNER JOIN address ON user.address_id = address.a_id
        WHERE user.u_id = :id
    """
    )
    suspend fun getFullUser(id: String): FullUser

    @Insert
    suspend fun insertAddress(address: Address)

    @Insert
    suspend fun insertUser(user: User)

    @Insert
    suspend fun insertUserPicture(userPicture: UserPicture)

    @Query("DELETE FROM address")
    suspend fun clear()
}