package ru.cib.receiverspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class ReceiverSpringBootApplication

fun main(args: Array<String>) {
    runApplication<ReceiverSpringBootApplication>(*args)
}
