package com.gls.parcelshop.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.gls.parcelshop.model.DeliveryState
import com.gls.parcelshop.model.Parcel
import java.time.LocalDate

data class ParcelApi(
    val parcelNumber: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val deliveryDate: LocalDate,
    val deliveryState: DeliveryState
)

fun Parcel.toApi(): ParcelApi{
    throw NotImplementedError()
}
