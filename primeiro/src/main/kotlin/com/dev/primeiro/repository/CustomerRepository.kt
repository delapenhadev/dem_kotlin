package com.dev.primeiro.repository

import com.dev.primeiro.entities.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Long> {

    fun findByLastName(lastName:String): Iterable<Customer>
}