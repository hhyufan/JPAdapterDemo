package com.adapt.jpadapterdemo.adapter.repository

import com.adapt.jpadapterdemo.entity.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface MyBatisUserRepository {
    @Select("SELECT * FROM user WHERE id = #{id}")
    fun findById(id: Long): User?
    @Insert("INSERT INTO user (id, name, email) VALUES (#{id}, #{name}, #{email})")
    fun save(user: User): Int
}
