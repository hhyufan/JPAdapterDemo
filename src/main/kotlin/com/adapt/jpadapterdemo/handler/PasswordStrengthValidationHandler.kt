package com.adapt.jpadapterdemo.handler

import com.adapt.jpadapterdemo.entity.User

class PasswordStrengthValidationHandler : UserValidationHandler() {
    private var nextHandler: UserValidationHandler? = null

    override fun setNext(handler: UserValidationHandler): UserValidationHandler {
        nextHandler = handler
        return handler
    }

    override fun handle(user: User) {
        // 定义密码强度的正则表达式
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@!%*#?&])[A-Za-z\\d$@!%*#?&]{8,24}$".toRegex()

        // 使用正则表达式验证密码
        if (!passwordRegex.matches(user.password)) {
            super.currentError = "密码强度低！"
            println(currentError)
            return
        }

        // 如果验证通过，继续调用下一个处理器
        nextHandler?.handle(user)
    }
}
