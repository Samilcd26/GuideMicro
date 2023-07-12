package com.guide.userservice.business.impl

import com.guide.userservice.business.UserService
import com.guide.userservice.data.models.OrganizerModel

import com.guide.userservice.data.models.UserModel
import com.guide.userservice.data.repository.OrganizerRepository
import com.guide.userservice.data.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    @Autowired
    var userRepository: UserRepository,
    @Autowired
    var organizerRepository: OrganizerRepository
):UserService {
    override fun getUserById(id: Long): UserModel {
        var currentUser:UserModel=userRepository.findById(id).orElseThrow()
        return currentUser

    }

    override fun createNewUser(user: UserModel): UserModel? {
        return try {
            userRepository.save(user)
            user
        }catch (e:Exception) {
            println(e)
            user
        }
    }

    override fun updateUserById(id: Long, userModel: UserModel) {
        TODO("Not yet implemented")
    }

    override fun deleteUserById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getFollowOrganizerListById(idList: List<Long?>): List<OrganizerModel>? {

        var test:List<OrganizerModel>?

        var tsss=idList.asIterable()
        try {

            test =organizerRepository.findAllById(tsss)
            return test
        }catch (e:Exception){
            println(e)
            return organizerRepository.findAllById(tsss)
        }

    }

    override fun toBeOrganizer(userId: Long): UserModel? {
        var currentUser:UserModel=userRepository.findById(userId).orElseThrow()
        currentUser.isOrganizer=true
        var newOrganizer:OrganizerModel = OrganizerModel(id = currentUser.id,email = currentUser.email, title = currentUser.firstName, verify = false, description = "", image = currentUser.imageURL)
        organizerRepository.save(newOrganizer)
        currentUser.byOrganized=newOrganizer
        userRepository.save(currentUser)
        return currentUser
    }


}