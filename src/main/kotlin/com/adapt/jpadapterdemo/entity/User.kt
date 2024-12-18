package com.adapt.jpadapterdemo.entity


import com.adapt.jpadapterdemo.dto.UserDTO
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class User(
    @Id val id: Long,
    val name: String,
    val email: String,
    val password: String
)
fun User.toDTO(): UserDTO {
    return UserDTO(
        id = this.id,
        username = this.name,
        password = this.password,
        email = this.email
    )
}
