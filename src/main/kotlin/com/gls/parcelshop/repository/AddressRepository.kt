package com.gls.parcelshop.repository

import com.gls.parcelshop.model.Address
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : CrudRepository<Address, Long> {
    override fun findAll(): List<Address>
}
