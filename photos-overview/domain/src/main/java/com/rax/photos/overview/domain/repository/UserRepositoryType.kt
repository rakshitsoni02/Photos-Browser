package com.rax.photos.overview.domain.repository

import com.rax.photos.overview.domain.model.User
import io.reactivex.rxjava3.core.Single

interface UserRepositoryType {
    fun getUsers(): Single<List<User>>
}