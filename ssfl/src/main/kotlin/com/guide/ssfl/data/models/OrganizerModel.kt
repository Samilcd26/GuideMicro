package com.guide.ssfl.data.models

import com.guide.userservice.data.models.SubModels.Address
import jakarta.persistence.CascadeType
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.Pattern
import lombok.Builder
import java.time.LocalDateTime

@Builder
@Entity
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
