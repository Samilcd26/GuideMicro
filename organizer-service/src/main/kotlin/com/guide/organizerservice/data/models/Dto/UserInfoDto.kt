package com.guide.organizerservice.data.models.Dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class UserInfoDto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    var userName:String? = null,
    var imageURL:String? = null,
    var followOrganizer:MutableList<Long>?= arrayListOf(),
)
