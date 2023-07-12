package com.guide.organizerservice.data.models


import com.guide.organizerservice.data.models.SubModels.EventCategory
import javax.persistence.*


data class PartnerModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null,
    var imageUrl:String?=null,
    var name:String?=null,
    @Column(length = 600)
    var about:String?=null,
    var aboutLink:String?=null,
    var category: EventCategory?=null,

    )