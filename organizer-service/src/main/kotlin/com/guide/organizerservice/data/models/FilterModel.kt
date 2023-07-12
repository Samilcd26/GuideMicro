package com.guide.organizerservice.data.models


import com.guide.organizerservice.data.models.SubModels.EventCategory
import java.sql.Time
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.swing.event.DocumentEvent.EventType

@Entity
data class FilterModel(
    @Enumerated(EnumType.STRING)
    var eventType: EventType?=null,

    var country:String?=null,
    var city:String?=null,
    var userId:Long?=null,

    var online:Boolean?=null,
    var ticketNeed:Boolean?=null,

    //Yap
    var verifyAccount:Boolean?=null,

    //
    var endDate:LocalDate?=null,
    var startDate:LocalDate?=null,
    var startHour:Time?=null,
    var endHour:Time?=null,
    //
    var onlyFollow:Boolean?=null,
    var free:Boolean?=null,


    var minPrice:Int?=null,
    var maxPrice:Int?=null,

    @Enumerated(EnumType.STRING)
    var selectCategory:List<EventCategory>?= emptyList(),


    )
