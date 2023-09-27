package com.gls.parcelshop.model

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "address")
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var street: String,
    var zip: String,
    var number: String,
    var consignee: String,

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private val parcel: Parcel? = null
) {
    constructor() : this(0,"",",","","")
}
