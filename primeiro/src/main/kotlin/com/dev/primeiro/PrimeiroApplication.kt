package com.dev.primeiro

import com.dev.primeiro.entities.Customer
import com.dev.primeiro.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PrimeiroApplication {
	private val log = LoggerFactory.getLogger(PrimeiroApplication::class.java)

	@Bean
	fun init(repository: CustomerRepository) = CommandLineRunner {
		repository.save(Customer("Jack","Bauer"))
		repository.save(Customer("Chloe","O,'Brian"))
		repository.save(Customer("Kim","Bauer"))
		repository.save(Customer("David","Palmer"))
		repository.save(Customer("Michelle","Dessler"))

		// fetch all customers
		log.info("Customer found with findAll():")
		log.info("-------------------------------")
		repository.findAll().forEach{log.info(it.toString())}
		log.info("")

		// customer an individual customer by ID
		val customer = repository.findById(1L)
		customer.ifPresent {
			log.info("Customer found with findById(1L):")
			log.info("-------------------------------")
			log.info(it.toString())
			log.info("")
		}

		log.info("Customer found with findByLastName('Bauer'):")
		log.info("----------------------------------------------")
		repository.findByLastName("Bauer").forEach { log.info(it.toString()) }


	}
}



fun main(args: Array<String>) {
	runApplication<PrimeiroApplication>(*args)
}
