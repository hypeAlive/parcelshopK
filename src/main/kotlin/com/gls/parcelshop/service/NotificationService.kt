package com.gls.parcelshop.service

import com.gls.parcelshop.model.Parcel
import com.gls.parcelshop.util.ApplicationLogger.info
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class NotificationService {
    fun notifySomeoneAboutChange(parcel: Parcel?) {
        info("Notification about parcel: $parcel")
    }
}
