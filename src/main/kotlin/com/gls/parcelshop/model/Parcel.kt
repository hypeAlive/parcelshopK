package com.gls.parcelshop.model

import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "parcel")
class Parcel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var parcelNumber: @NotNull String,
    var deliveryDate: String,
    var deliveryState: DeliveryState,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    var address: Address
) {

    constructor() : this(0, "12345678903", "20230912", DeliveryState.DELIVERED, Address(0, "", ",", "", ""))
}
