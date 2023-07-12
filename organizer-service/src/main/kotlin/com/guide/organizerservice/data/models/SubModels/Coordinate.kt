package com.guide.organizerservice.data.models.SubModels


import javax.persistence.*


data class Coordinate(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    var id:Long?=null,
    val latitude:Double? = null,
    val longitude:Double? = null
)
