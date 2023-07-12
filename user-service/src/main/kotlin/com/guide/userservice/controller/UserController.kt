package com.guide.userservice.controller

import com.guide.userservice.business.UserService
import com.guide.userservice.data.models.OrganizerModel

import com.guide.userservice.data.models.UserModel
import com.guide.userservice.data.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController (val userService: UserService){


    @PostMapping("/create")
    fun createNewUser(@RequestBody userModel: UserModel): ResponseEntity<UserModel> {
        return ResponseEntity.ok(userService.createNewUser(userModel))
    }

    @PostMapping("/update")
    fun updateUser(@RequestParam id:Long,@RequestBody userModel: UserModel) {
        return userService.updateUserById(id,userModel)
    }
    @GetMapping("/find")
    fun getUserById(@RequestParam id:Long):UserModel?{
        return userService.getUserById(id)
    }

    @GetMapping("/getFollowers")
    fun getFollowerByUser(@RequestBody followerIdList: List<Long>):List<OrganizerModel>?{
        return userService.getFollowOrganizerListById(followerIdList)
    }

    @GetMapping("/toBeOrganizer")
    fun toBeOrganizer(@RequestParam userId:Long):UserModel?{
        return userService.toBeOrganizer(userId)
    }

}