package com.guide.ssfl.data.models

import com.guide.ssfl.data.dto.UserInfoDto
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Comment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    var id:Long?=null,

    @ManyToOne(cascade = [(CascadeType.ALL)] ,fetch = FetchType.LAZY)
    var addedUser:UserInfoDto?=null,
    var contents:String?=null,
    @ElementCollection
    var likeed:MutableList<Long>?= arrayListOf(),

    @ElementCollection
    var subComment:MutableList<Long>?=arrayListOf(),
    var createdDate:LocalDateTime?=LocalDateTime.now(),
    var changedDate:LocalDateTime?=LocalDateTime.now(),
)