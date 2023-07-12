package com.guide.ssfl.controller

import com.guide.ssfl.business.SSFLService
import com.guide.ssfl.data.models.Comment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/ssfl")
class SSFLController(
    val ssflService: SSFLService,
) {


    @GetMapping("/followOrganizer")
    fun followOrganizer(@RequestParam userId:Long, @RequestParam organizerId:Long):List<Long>?{
        return ssflService.followOrganizer(userId,organizerId)
    }
    @DeleteMapping("/unfollowOrganizer")
    fun unfollowOrganizer(@RequestParam userId:Long, @RequestParam organizerId:Long):List<Long>?{
        return ssflService.unfollowOrganizer(userId,organizerId)
    }

    @GetMapping("/likeEvent")
    fun addLikeToEvent(@RequestParam userId:Long,@RequestParam eventId:Long): ResponseEntity<List<Long>> {
        return ResponseEntity.ok(ssflService.likeEvent(userId,eventId))
    }

    @DeleteMapping("/removeLikeEvent")
    fun removeLikeEvent(@RequestParam userId:Long, @RequestParam eventId:Long):List<Long>?{
        return ssflService.removeLikeEvent(userId,eventId)
    }
    @GetMapping("/dislikeEvent")
    fun dislikeEvent(@RequestParam userId:Long,@RequestParam eventId:Long): ResponseEntity<List<Long>> {
        return ResponseEntity.ok(ssflService.likeEvent(userId,eventId))
    }

    @DeleteMapping("/removeDislikeEvent")
    fun removeDislikeEvent(@RequestParam userId:Long, @RequestParam eventId:Long):List<Long>?{
        return ssflService.removeLikeEvent(userId,eventId)
    }

    @GetMapping("/saveEventStore")
    fun saveOrganizerEventToUserStore(@RequestParam userId:Long, @RequestParam eventId:Long):List<Long>?{
        return ssflService.saveOrganizerEventFromUserStore(userId,eventId)
    }

    @DeleteMapping("/removeEventStore")
    fun removeOrganizerEventToUserStore(@RequestParam userId:Long, @RequestParam eventId:Long):List<Long>?{
        return ssflService.removeOrganizerEventFromUserStore(userId,eventId)
    }
    @PostMapping("/addComment")
    fun addCommentToEvent(@RequestParam userId:Long, @RequestParam eventId:Long,@RequestBody comment: Comment):List<Long>?{
        return ssflService.addCommentToEvent(userId,eventId,comment)
    }
    @DeleteMapping("/removeComment")
    fun removeCommentToEvent(@RequestParam userId:Long, @RequestParam eventId:Long,@RequestParam commentId:Long):List<Long>?{
        return ssflService.removeCommentToEvent(userId,eventId, commentId)
    }


    @GetMapping("/getComment")
    fun getCommentList(@RequestBody commentIdList:List<Long>):List<Comment>?{
        return ssflService.getCommentList(commentIdList)
    }
}