package com.adapt.jpadapterdemo.adapter

import com.adapt.jpadapterdemo.entity.User
import com.adapt.jpadapterdemo.observer.UserObserver

interface Target {
    fun findById(id: Long): User?
    fun save(user: User): User
    fun findByName(username: String): User?
    fun findByEmail(email: String): User?
    fun addObserver(userObserver: UserObserver)
}
