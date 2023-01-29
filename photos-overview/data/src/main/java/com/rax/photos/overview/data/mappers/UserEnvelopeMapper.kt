package com.rax.photos.overview.data.mappers

import com.rax.photos.overview.data.envelopes.UserEnvelope
import com.rax.photos.overview.domain.model.User

object UserEnvelopeMapper {

    fun mapFrom(from: UserEnvelope): User {
        return User(
            id = from.id,
            username = from.username,
            name = from.name,
            email = from.email,
        )
    }
}