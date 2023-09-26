package com.gls.parcelshop.service;

import com.gls.parcelshop.model.Parcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    public void notifySomeoneAboutChange(Parcel parcel) {
        log.info("Notification about parcel: {}", parcel);
    }

}
