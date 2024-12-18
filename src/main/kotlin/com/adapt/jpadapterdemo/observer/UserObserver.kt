package com.adapt.jpadapterdemo.observer

import com.adapt.jpadapterdemo.entity.User

interface UserObserver {
    fun onUserSaved(user: User)
}
