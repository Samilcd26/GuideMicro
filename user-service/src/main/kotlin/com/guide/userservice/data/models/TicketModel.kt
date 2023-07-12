package com.guide.userservice.data.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
data class TicketModel(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id:String?=null,
    var eventId:Long?=null,
    var name:String?=null,
    var imageUrl:String?=null,
    var description:String?=null,
    var createdDate: LocalDateTime?= LocalDateTime.now(),
    var changedDate: LocalDateTime?=LocalDateTime.now(),
    var status:String?=null,
    var price:Int?=0,

    )