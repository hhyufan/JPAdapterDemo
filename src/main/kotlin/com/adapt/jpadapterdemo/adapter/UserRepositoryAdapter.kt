package com.adapt.jpadapterdemo.adapter


import com.adapt.jpadapterdemo.adapter.repository.MyBatisUserRepository
import com.adapt.jpadapterdemo.entity.User
import com.adapt.jpadapterdemo.observer.UserObserver
import com.adapt.jpadapterdemo.repository.JpaUserRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(
    private val myBatisRepository: MyBatisUserRepository,
    private val jpaRepository: JpaUserRepository
) : Target {
    private val observers = mutableListOf<UserObserver>()
    override fun findById(id: Long): User? {
        return myBatisRepository.findById(id)

    }

    override fun findByName(username: String): User? {
        return jpaRepository.findByName(username)

    }

    override fun findByEmail(email: String): User? {
        return jpaRepository.findByEmail(email)

    }

    override fun save(user: User): User {
        val savedUser = jpaRepository.save(user)
        notifyObservers(savedUser)
        return jpaRepository.save(user)
    }
    private fun notifyObservers(user: User) {
        for (observer in observers) {
            observer.onUserSaved(user)
        }
    }

    override fun addObserver(userObserver: UserObserver) {
        observers.add(userObserver)
    }
}
