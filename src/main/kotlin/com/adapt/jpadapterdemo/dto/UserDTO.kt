package com.adapt.jpadapterdemo.dto;

import com.adapt.jpadapterdemo.entity.User

data class UserDTO(
    val id: Long,
    val username: String,
    val password: String,
    val email: String
)
fun UserDTO.toUser(): User {
    return User(
        id = this.id,
        name = this.username,
        password = this.password,
        email = this.email
    )
}
