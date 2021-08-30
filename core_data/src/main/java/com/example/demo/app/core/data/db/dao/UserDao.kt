package com.example.demo.app.core.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demo.app.core.data.db.entity.user.Address
import com.example.demo.app.core.data.db.entity.user.User
import com.example.demo.app.core.data.db.entity.user.UserPicture
import com.example.demo.app.core.data.db.entity.user.UserWithPicture
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAddress(address: Address)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPicture(userPicture: UserPicture)

    @Query("DELETE FROM address")
    suspend fun clear()
}