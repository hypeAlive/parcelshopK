package com.gls.parcelshop.repository

import com.gls.parcelshop.model.DeliveryState
import com.gls.parcelshop.model.Parcel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ParcelRepository : CrudRepository<Parcel, Long> {
    override fun findAll(): List<Parcel>
    fun findAllByParcelNumber(parcelNumber: String): List<Parcel>
    fun findAllByDeliveryDateAndDeliveryState(deliveryDate: String, deliveryState: DeliveryState): List<Parcel>
    fun findAllByDeliveryState(deliveryState: DeliveryState): List<Parcel>
}
