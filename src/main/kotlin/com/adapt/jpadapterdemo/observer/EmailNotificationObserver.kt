package com.adapt.jpadapterdemo.observer

import com.adapt.jpadapterdemo.entity.User

class EmailNotificationObserver : UserObserver {
    override fun onUserSaved(user: User) {
        println("发送邮箱To ${user.name}")
        // 后续可以添加邮箱系统，一些数据库操作
        // 将邮箱监听者触发的记录保存到邮箱里面。
    }
}
