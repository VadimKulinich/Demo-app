package com.example.demo.app.core.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.demo.app.core.data.db.entity.Comment
import com.example.demo.app.core.data.db.entity.CommentWithUser

@Dao
interface CommentDao {

    @Query(
        """
        SELECT *
        FROM comment INNER JOIN user ON comment.from_user_id = user.id
        WHERE comment.to_user_id = :userId
    """
    )
    suspend fun getCommentsForUser(userId: String): List<CommentWithUser>

    @Insert
    suspend fun insert(comment: Comment)

    @Query("DELETE FROM comment WHERE comment.from_user_id == :fromUser AND to_user_id = :toUser")
    fun delete(fromUser: String, toUser: String)
}