package com.adapt.jpadapterdemo.repository


import com.adapt.jpadapterdemo.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface JpaUserRepository : JpaRepository<User?, Long?> {
    fun findByName(username: String?): User?

    fun findByEmail(email: String?): User?
}
