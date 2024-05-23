package ru.cib.receiverspringboot.service

import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.Exchange
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class RabbitSenderService(
    private val rabbitTemplate: RabbitTemplate
) {

    @Scheduled(fixedDelay = 2000L)
    @Bean
    fun sendToRabbit() {
        println("qwert")
        rabbitTemplate.send("test", Message("test".toByteArray()))
    }

}