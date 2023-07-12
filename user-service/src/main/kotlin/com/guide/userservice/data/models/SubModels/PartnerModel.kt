package com.guide.userservice.data.models.SubModels

import com.guide.userservice.data.models.Enum.EventCategory
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
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