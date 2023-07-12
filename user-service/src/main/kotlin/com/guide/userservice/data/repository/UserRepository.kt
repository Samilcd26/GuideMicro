package com.guide.userservice.data.repository

import com.guide.userservice.data.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Repository
import java.util.Optional


@Repository
interface UserRepository :JpaRepository<UserModel,Long>{
    fun findByEmail(email:String):Optional<UserModel>
}