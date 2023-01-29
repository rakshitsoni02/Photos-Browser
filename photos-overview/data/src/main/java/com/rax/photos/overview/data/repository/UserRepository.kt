package com.rax.photos.overview.data.repository

import com.rax.photos.overview.data.envelopes.*
import com.rax.photos.overview.data.mappers.UserEnvelopeMapper
import com.rax.photos.overview.data.network.UserApiType
import com.rax.photos.overview.domain.model.User
import com.rax.photos.overview.domain.repository.UserRepositoryType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@OptIn(ExperimentalStdlibApi::class)
class UserRepository @Inject constructor(
    private val apiType: UserApiType,
    private val moshi: Moshi
) : UserRepositoryType {

    override fun getUsers(): Single<List<User>> {
        return apiType.fetchUsers().map {
            val responseBody = it.body
            val responseEnvelope =
                requireNotNull(moshi.adapter<List<UserEnvelope>>().fromJson(responseBody))
            responseEnvelope.map(UserEnvelopeMapper::mapFrom)
        }
    }
}