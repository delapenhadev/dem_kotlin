package com.dev.primeiro.controller

import com.dev.primeiro.entities.Customer
import com.dev.primeiro.repository.CustomerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(private val repository: CustomerRepository){

    @GetMapping("/customers")
    fun findAll() = ResponseEntity.ok().body(repository.findAll())

    @GetMapping("/{id}")
    fun findByI(@PathVariable id: Long) = repository.findById(id).get()

    @GetMapping("/customers/{lastName}")
    fun findByLastName(@PathVariable lastName:String)
                     = repository.findByLastName(lastName)

}