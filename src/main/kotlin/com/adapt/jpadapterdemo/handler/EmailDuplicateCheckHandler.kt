package com.adapt.jpadapterdemo.handler

import com.adapt.jpadapterdemo.adapter.Target
import com.adapt.jpadapterdemo.entity.User

class EmailDuplicateCheckHandler(private var target: Target) : UserValidationHandler() {
    private var nextHandler: UserValidationHandler? = null

    override fun setNext(handler: UserValidationHandler): UserValidationHandler {
        nextHandler = handler
        return handler
    }

    override fun handle(user: User) {
        if (target.findByName(user.email) != null) {
            currentError = "邮箱已存在！"
            println(currentError)
            return
        }
        nextHandler?.handle(user)
    }
}
