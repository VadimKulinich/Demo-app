package com.example.demo.app.feature.feed.data

import com.example.demo.app.core.data.db.SuspendTransactionExecutor
import com.example.demo.app.core.data.db.dao.UserDao
import com.example.demo.app.core.data.db.entity.FullUser
import com.example.demo.app.core.data.db.entity.UserWithPicture
import com.example.demo.app.core.data.model.UserPictureType
import com.example.demo.app.feature.feed.data.mapper.UserResponseToAddressMapper
import com.example.demo.app.feature.feed.data.mapper.UserResponseToPictureMapper
import com.example.demo.app.feature.feed.data.mapper.UserResponseToUserMapper
import com.example.demo.app.feature.feed.data.network.UserApi
import com.example.demo.app.feature.feed.domain.FeedRepository
import kotlinx.coroutines.flow.Flow

class FeedRepositoryImpl(
    private val userDao: UserDao,
    private val userApi: UserApi,
    private val suspendTransactionExecutor: SuspendTransactionExecutor,
    private val userMapper: UserResponseToUserMapper,
    private val addressMapper: UserResponseToAddressMapper,
    private val pictureMapper: UserResponseToPictureMapper,
) : FeedRepository {

    override suspend fun fetchUsers() {
        val userList = userApi.loadUsers()
        userList.users.forEach { user ->
            val address = addressMapper.map(user)
            val dbUser = userMapper.map(user, address.id)
            val pictures = pictureMapper.map(dbUser.id, user.picture)
            suspendTransactionExecutor.inTransaction {
                userDao.insertAddress(address)
                userDao.insertUser(dbUser)
                pictures.forEach { picture ->
                    userDao.insertUserPicture(picture)
                }
            }
        }
    }

    override suspend fun clear() {
        userDao.clear()
    }

    override fun observeFeed(): Flow<List<UserWithPicture>> =
        userDao.observeUsers(UserPictureType.LARGE)

    override suspend fun loadUser(id: String): FullUser = userDao.getFullUser(id)
}