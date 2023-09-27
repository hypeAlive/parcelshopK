package com.gls.parcelshop.dto

import com.gls.parcelshop.model.DeliveryState
import com.gls.parcelshop.model.Parcel
import java.time.LocalDate

data class ParcelApi(
    val parcelNumber: String,
    val deliveryDate: LocalDate,
    val deliveryState: DeliveryState
)

fun Parcel.toApi(): ParcelApi{
    throw NotImplementedError()
}
