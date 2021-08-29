package com.example.demo.app.feature.feed.random.user.data

import com.example.demo.app.core.data.db.SuspendTransactionExecutor
import com.example.demo.app.core.data.db.dao.UserDao
import com.example.demo.app.core.data.db.entity.user.UserWithPicture
import com.example.demo.app.core.data.model.UserPictureType
import com.example.demo.app.feature.feed.random.user.data.mapper.UserResponseToAddressMapper
import com.example.demo.app.feature.feed.random.user.data.mapper.UserResponseToPictureMapper
import com.example.demo.app.feature.feed.random.user.data.mapper.UserResponseToUserMapper
import com.example.demo.app.feature.feed.random.user.data.network.UserApi
import com.example.demo.feature.feed.domain.api.FeedRepository
import kotlinx.coroutines.flow.Flow

internal class UsersFeedRepositoryImpl(
    private val userDao: UserDao,
    private val userApi: UserApi,
    private val suspendTransactionExecutor: SuspendTransactionExecutor,
    private val userMapper: UserResponseToUserMapper,
    private val addressMapper: UserResponseToAddressMapper,
    private val pictureMapper: UserResponseToPictureMapper,
) : FeedRepository<UserWithPicture> {

    override suspend fun fetch() {
        val userList = userApi.loadUsers(results = 5)
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

    override fun observe(): Flow<List<UserWithPicture>> =
        userDao.observeUsers(UserPictureType.LARGE)
}