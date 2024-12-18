package com.adapt.jpadapterdemo.handler;

import com.adapt.jpadapterdemo.entity.User

abstract class UserValidationHandler {
    var currentError: String? = null;
    abstract fun setNext(handler: UserValidationHandler): UserValidationHandler
    abstract fun handle(user: User)
}
