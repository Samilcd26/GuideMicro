package com.guide.userservice.business

import com.guide.userservice.data.models.OrganizerModel
import com.guide.userservice.data.models.UserModel

interface UserService {

    fun createNewUser(user: UserModel): UserModel?
    fun updateUserById(id:Long,userModel: UserModel)
    fun deleteUserById(id:Long)
    fun getUserById(id:Long):UserModel?
    fun getFollowOrganizerListById(id:List<Long?>):List<OrganizerModel>?
    fun toBeOrganizer(userId:Long):UserModel?

}