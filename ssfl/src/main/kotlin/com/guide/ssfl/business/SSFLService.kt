package com.guide.ssfl.business

import com.guide.ssfl.data.models.Comment
import com.guide.ssfl.data.models.OrganizerModel
import com.guide.ssfl.data.models.UserModel


interface SSFLService {

    fun followOrganizer(userId:Long,organizerId:Long):List<Long>?
    fun unfollowOrganizer(userId:Long,organizerId:Long):List<Long>?

    fun likeEvent(userId:Long,eventId:Long):List<Long>?

    fun removeLikeEvent(userId:Long, eventId:Long):List<Long>?

    fun dislikeEvent(userId:Long,eventId:Long):List<Long>?

    fun removeDislikeEvent(userId:Long,eventId:Long):List<Long>?

    fun saveOrganizerEventFromUserStore(userId:Long,eventId:Long):List<Long>?
    fun removeOrganizerEventFromUserStore(userId:Long, eventId:Long):List<Long>?

    fun addCommentToEvent(userId:Long,eventId:Long,comment: Comment):List<Long>?
    fun removeCommentToEvent(userId:Long,eventId:Long,commentId:Long):List<Long>?
    fun addNewFollowed(organizerId:Long,followedId: Long): UserModel
    fun removeFollowed(organizerId:Long,followedId: Long): UserModel
    fun addNewFollower(organizerId:Long,followerId: Long): OrganizerModel
    fun removeFollower(organizerId:Long,followerId: Long): OrganizerModel
    fun getCommentList(commentIdList:List<Long>):List<Comment>
}
