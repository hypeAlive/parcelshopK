package com.gls.parcelshop.controller

import com.gls.parcelshop.model.Address
import com.gls.parcelshop.model.DeliveryState
import com.gls.parcelshop.model.Parcel
import com.gls.parcelshop.repository.ParcelRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class ParcelControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var parcelRepository: ParcelRepository

    private fun createParcels(): List<Parcel> {
        return listOf(
            Parcel(
                address = Address(consignee = "Test", street = "TestStreet", number = "1", zip = "10785"),
                parcelNumber = "1001",
                deliveryDate = "20200420",
                deliveryState = DeliveryState.OUT_FOR_DELIVERY
            ),
            Parcel(
                address = Address(consignee = "Test2", street = "TestStreet2", number = "1", zip = "10785"),
                parcelNumber = "1002",
                deliveryDate = "20200421",
                deliveryState = DeliveryState.OUT_FOR_DELIVERY
            )
        )
    }

    @Test
    fun `should return parcels out for delivery`() {
        val parcels = createParcels()
        Mockito.`when`(parcelRepository.findAllByDeliveryState(DeliveryState.OUT_FOR_DELIVERY)).thenReturn(parcels)
        Mockito.`when`(
            parcelRepository.findAllByDeliveryDateAndDeliveryState(
                "20200421",
                DeliveryState.OUT_FOR_DELIVERY
            )
        ).thenReturn(parcels.filter { it.deliveryDate == "20200421" })

        mockMvc.perform(get("/api/v1/parcels/out-for-delivery"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].parcelNumber").value("1001"))

        mockMvc.perform(get("/api/v1/parcels/out-for-delivery?deliveryDate=20200421"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].parcelNumber").value("1002"))
    }

    @Test
    fun `should return all parcels`() {
        val parcels = createParcels()
        Mockito.`when`(parcelRepository.findAll()).thenReturn(parcels)

        mockMvc.perform(get("/api/v1/parcels"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].parcelNumber").value("1001"))
            .andExpect(jsonPath("$[1].parcelNumber").value("1002"))
    }

}