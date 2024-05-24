package ru.cib.receiverspringboot.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitConfig {

    @Bean
    fun producerJackson2MessageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun studentDirectExchange() = DirectExchange("students")

    @Bean
    fun studentQueue() = Queue("student")

    @Bean
    fun studentBinding(): Binding = BindingBuilder.bind(studentQueue()).to(studentDirectExchange()).with("student")
}