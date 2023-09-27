package com.gls.parcelshop.controller

import com.gls.parcelshop.model.Parcel
import com.gls.parcelshop.repository.ParcelRepository
import com.gls.parcelshop.service.NotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ParcelController(
    private val notificationService: NotificationService
) {

    @Autowired
    private val parcelRepository: ParcelRepository? = null

    @GetMapping("/parcels")
    @ResponseStatus(HttpStatus.CREATED)
    fun getAllParcels(): List<Parcel> {
        return parcelRepository!!.findAll()
    }

    @PostMapping(value = ["/parcels"], consumes = ["application/json"])
    @ResponseStatus(HttpStatus.CREATED)
    fun insertNewParcels(@RequestBody parcel: Parcel): ResponseEntity<Parcel> {
        val savedParcel = parcelRepository!!.save(parcel)
        notificationService.notifySomeoneAboutChange(savedParcel)
        return ResponseEntity(savedParcel, HttpStatus.CREATED)
    }
}
