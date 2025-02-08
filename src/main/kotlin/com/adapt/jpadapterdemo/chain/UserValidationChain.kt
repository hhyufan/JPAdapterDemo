package com.adapt.jpadapterdemo.chain

import com.adapt.jpadapterdemo.adapter.Target
import com.adapt.jpadapterdemo.entity.User
import com.adapt.jpadapterdemo.handler.EmailDuplicateCheckHandler
import com.adapt.jpadapterdemo.handler.EmailFormatValidationHandler
import com.adapt.jpadapterdemo.handler.PasswordStrengthValidationHandler
import com.adapt.jpadapterdemo.handler.UsernameDuplicateCheckHandler

class UserValidationChain(target: Target) {
    private val usernameDuplicateCheck = UsernameDuplicateCheckHandler(target)
    private val emailDuplicateCheck = EmailDuplicateCheckHandler(target)
    private val emailCheck = EmailFormatValidationHandler()
    private val passwordStrengthCheck = PasswordStrengthValidationHandler()

    init {
        // 建立责任链 emailCheck: EmailFormatValidationHandler
        usernameDuplicateCheck.setNext(emailCheck)
            .setNext(emailDuplicateCheck)
            .setNext(passwordStrengthCheck)
    }

    fun validate(user: User): String? {

        usernameDuplicateCheck.handle(user)
        return usernameDuplicateCheck.currentError ?: emailDuplicateCheck.currentError?: emailCheck.currentError ?: passwordStrengthCheck.currentError
            // 如果没有错误，返回 null
    }
}
