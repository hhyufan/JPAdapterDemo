package com.adapt.jpadapterdemo.chain

import com.adapt.jpadapterdemo.adapter.Target
import com.adapt.jpadapterdemo.entity.User
import com.adapt.jpadapterdemo.handler.EmailFormatValidationHandler
import com.adapt.jpadapterdemo.handler.PasswordStrengthValidationHandler
import com.adapt.jpadapterdemo.handler.UsernameDuplicateCheckHandler

class UserValidationChain(private val target: Target) {
    private val usernameCheck = UsernameDuplicateCheckHandler(target)
    private val emailCheck = EmailFormatValidationHandler()
    private val passwordStrengthCheck = PasswordStrengthValidationHandler()

    init {
        // 建立责任链 emailCheck: EmailFormatValidationHandler
        usernameCheck.setNext(emailCheck)
            .setNext(passwordStrengthCheck)
    }

    fun validate(user: User): String? {

        usernameCheck.handle(user)
        return usernameCheck.currentError ?: emailCheck.currentError ?: passwordStrengthCheck.currentError
            // 如果没有错误，返回 null
    }
}
