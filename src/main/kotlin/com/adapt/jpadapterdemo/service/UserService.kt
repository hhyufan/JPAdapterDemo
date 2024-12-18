package com.adapt.jpadapterdemo.service;

import com.adapt.jpadapterdemo.adapter.Target
import com.adapt.jpadapterdemo.entity.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val target: Target
) {
    fun registerUser(user: User): User {
        return target.save(user)
    }

    fun loginUser(username: String, password: String): User? {
        val user = target.findByName(username)
        return if (user != null && user.password == password) {
            user
        } else {
            null
        }
    }
}
