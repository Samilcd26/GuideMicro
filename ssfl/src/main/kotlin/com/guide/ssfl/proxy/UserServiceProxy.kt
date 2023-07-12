package com.guide.ssfl.proxy

import com.guide.ssfl.data.models.UserModel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*


@FeignClient(name = "user-service")
interface UserServiceProxy {


    @GetMapping("/user/")
    fun getUserById(@RequestParam id:Long):UserModel?

    @PostMapping("/user/update")
    fun updateUser(@RequestParam id:Long, @RequestBody userModel: UserModel)
}