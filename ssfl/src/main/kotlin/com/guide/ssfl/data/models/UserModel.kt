package com.guide.ssfl.data.models


import com.fasterxml.jackson.annotation.JsonFormat
import com.guide.ssfl.data.Enum.Role

import jakarta.persistence.CascadeType
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.Pattern

import java.time.LocalDate




@Entity
data class UserModel(
    var accessToken:String?=null,

    var refreshToken:String?=null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null,
    var userName:String?=null,
    var firstName:String?=null,
    var lastName:String?=null,
    var telNumber:Long?=null,
    @JsonFormat(pattern="dd/MM/yyyy")
    var birtDate:LocalDate?=null,
    var userPassword:String?=null,
    @Pattern(regexp = "\b[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}\b.")
    var email:String?=null,
    var isOrganizer:Boolean?=false,

    @OneToOne(cascade = [(CascadeType.ALL)] ,fetch = FetchType.LAZY)
    var byOrganized:OrganizerModel?= null,
    var imageURL:String?="https://upload.wikimedia.org/wikipedia/commons/2/2c/Default_pfp.svg",
    @ElementCollection
    var likeList:MutableList<Long>?=arrayListOf(),
    @ElementCollection
    var disLikeList:MutableList<Long>?=arrayListOf(),
    @ElementCollection
    var followOrganizer:MutableList<Long>?= arrayListOf(),


    @ElementCollection
    var userEventStore:MutableList<Long>?= arrayListOf(),

    @Enumerated(EnumType.STRING)
    var role: Role?= Role.USER,

    @OneToMany(cascade = [(CascadeType.ALL)] ,fetch = FetchType.LAZY)
    var ticketList:MutableList<TicketModel>?=arrayListOf(),

    )
