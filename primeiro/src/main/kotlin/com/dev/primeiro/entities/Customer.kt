package com.dev.primeiro.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Customer(
    var firstName:String,
    var lastName:String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = - 1
)