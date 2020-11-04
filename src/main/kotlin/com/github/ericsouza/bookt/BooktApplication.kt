package com.github.ericsouza.bookt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BooktApplication

fun main(args: Array<String>) {
	runApplication<BooktApplication>(*args)
}
