package com.guide.organizerservice.business.services

import com.guide.organizerservice.data.models.Event
import com.guide.organizerservice.data.models.FilterModel
import com.guide.organizerservice.data.models.OrganizerModel
import com.guide.organizerservice.data.models.SubModels.Address

interface OrganizerServices {
    fun getAllOrganizerByFilter(filterModel: FilterModel):List<OrganizerModel>?
    fun getAllOrganizerById(organizerID:Long): OrganizerModel
    fun createNewOrganizer(organizer: OrganizerModel): OrganizerModel?
    fun updateOrganizerById(id:Long,organizer: OrganizerModel)
    fun deleteOrganizerById(id: Long)

    fun searchOrganizer(organizerName:String):List<OrganizerModel>?

    fun addNewEvent(organizerId:Long,event: Event): Event
    fun addAddressToEvent(eventId:Long, address: Address): Event
    fun removeEvent(organizerId:Long,eventId: Long): Event?

    fun addNewTagToEvent(eventEd:Long,tag:String):String
    fun removeTagToEvent(eventEd:Long,tagId:Long):String



}