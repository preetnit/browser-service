package com.preet.browserservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BrowserServiceApplication

fun main(args: Array<String>) {
	runApplication<BrowserServiceApplication>(*args)
}
