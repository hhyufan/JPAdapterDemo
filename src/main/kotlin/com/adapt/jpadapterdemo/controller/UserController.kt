package com.adapt.jpadapterdemo.controller

import com.adapt.jpadapterdemo.adapter.Target // 引入 Target 接口
import com.adapt.jpadapterdemo.adapter.UserRepositoryAdapter
import com.adapt.jpadapterdemo.chain.UserValidationChain
import com.adapt.jpadapterdemo.dto.UserDTO
import com.adapt.jpadapterdemo.dto.toUser
import com.adapt.jpadapterdemo.observer.EmailNotificationObserver
import com.adapt.jpadapterdemo.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class UserController(
    private val target: Target,
    private val userService: UserService
) { // 使用 Target 接口
    init {
        if (target is UserRepositoryAdapter) {
            target.addObserver(EmailNotificationObserver())
        }
    }
    @PostMapping("/register")
    @ResponseBody
    fun registerUser(@RequestBody userDto: UserDTO): ResponseEntity<Map<String, String>> {
        return try {

            val validationChain = UserValidationChain(target)

            // 执行验证
            val error = validationChain.validate(userDto.toUser())
            ResponseEntity.ok(
                if (error != null) {
                    mapOf("error" to error)
                } else {
                    userService.registerUser(userDto.toUser())
                    mapOf("message" to "注册成功!")
                }
            )
        } catch (e: Exception) {
            println("Error during registration: ${e.message}")
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapOf("error" to "An error occurred during registration"))
        }
    }

    @PostMapping("/login")
    @ResponseBody
    fun loginUser(@RequestBody loginData: Map<String, String>): ResponseEntity<Map<String, String>> {
        val username = loginData["username"]
        val password = loginData["password"]
        return try {
            val user = username?.let { password?.let { it1 -> userService.loginUser(it, it1) } }
            if (user != null) {
                ResponseEntity.ok(mapOf("message" to "登录成功!"))
            } else {
                ResponseEntity.ok(mapOf("error" to "用户名或密码错误"))
            }
        } catch (e: Exception) {
            println("Error during login: ${e.message}")
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapOf("error" to "An error occurred during login"))
        }
    }


    @GetMapping("/")
    fun platForm(model: Model): String {
        return "index"
    }

    @GetMapping("/success")
    fun successPage(model: Model): String {
        return "loading"
    }

}
