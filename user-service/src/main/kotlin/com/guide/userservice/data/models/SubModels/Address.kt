package com.guide.userservice.data.models.SubModels

import jakarta.persistence.*

@Entity
data class Address(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null,

    var eventId:Long?=null,
    var postalCode:String? = null,
    @Column(nullable=false)
    var country:String? = null,

    var state:String? = null,
    @Column(nullable=false)
    var city:String? = null,
    var district:String? = null,
    var address1:String?=null,
    var address2:String?=null,

    @ManyToOne(cascade = [(CascadeType.ALL)],fetch = FetchType.LAZY)
    var coordinate: Coordinate? = null,
)