package com.gls.parcelshop.controller;

import com.gls.parcelshop.model.Parcel;
import com.gls.parcelshop.repository.ParcelRepository;
import com.gls.parcelshop.service.NotificationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ParcelController {

    @Autowired
    private ParcelRepository parcelRepository;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/parcels")
    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    @PostMapping(value = "/parcels", consumes = "application/json")
    public ResponseEntity<Parcel> insertNewParcels(@RequestBody Parcel parcel) {
        Parcel savedParcel = parcelRepository.save(parcel);
        notificationService.notifySomeoneAboutChange(savedParcel);
        return new ResponseEntity<>(savedParcel, HttpStatus.CREATED);
    }

}
