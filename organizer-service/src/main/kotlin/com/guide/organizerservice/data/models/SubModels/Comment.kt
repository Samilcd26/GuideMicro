package com.guide.organizerservice.data.models.SubModels

import com.guide.organizerservice.data.models.Dto.UserInfoDto
import java.time.LocalDateTime
import javax.persistence.*

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