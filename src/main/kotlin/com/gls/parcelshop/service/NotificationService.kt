package com.gls.parcelshop.service

import com.gls.parcelshop.model.Parcel
import com.gls.parcelshop.util.ApplicationLogger.info
import org.springframework.stereotype.Service


@Service
class NotificationService {
    fun notifySomeoneAboutChange(parcel: Parcel?) {
        info("Notification about parcel: $parcel")
    }
}
