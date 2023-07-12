package com.guide.organizerservice.data.models

import com.guide.organizerservice.data.models.SubModels.Address
import jakarta.validation.constraints.Pattern
import javax.persistence.GeneratedValue
import javax.persistence.Id


import java.time.LocalDateTime
import javax.persistence.*





data class OrganizerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null,
    @Pattern(regexp = "\b[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}\b.")
    var email:String? = null,
    var organizerName:String?=null,
    var title:String? = null,
    var verify:Boolean?=false,
    var description: String? = null,
    var image:String? = null,
    var eventLimit:Int?=4,
    var eventLimitRefreshDate:LocalDateTime?= LocalDateTime.now().plusMonths(1),
    @ElementCollection
    var followedList:MutableList<Long>?= arrayListOf(),

    @ElementCollection
    var followerList:MutableList<Long>?= arrayListOf(),


    @OneToMany(cascade = [(CascadeType.ALL)] ,fetch = FetchType.LAZY)
    var address:MutableList<Address>? = arrayListOf(),

    @OneToMany(cascade = [(CascadeType.ALL)] ,fetch = FetchType.LAZY)
    var event:MutableList<Event>?=arrayListOf(),

    )

