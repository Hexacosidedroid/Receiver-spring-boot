package ru.cib.receiverspringboot.service

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.cib.receiverspringboot.domain.StudentStatuses
import ru.cib.receiverspringboot.repository.StudentRepository
import ru.cib.receiverspringboot.toDto

@Service
class RabbitSenderService(
    private val rabbitTemplate: RabbitTemplate,
    private val studentRepository: StudentRepository
) {

    @Scheduled(fixedDelay = 10000)
    fun sendToRabbit() {
        val listStudents = studentRepository.findAllByStatus(StudentStatuses.NEW)
        listStudents.forEach {
            it.status = StudentStatuses.PROCESSING
        }
        studentRepository.saveAll(listStudents)
        if (listStudents.isNotEmpty()) {
            rabbitTemplate.convertAndSend("student", listStudents.toDto())
        }
        listStudents.forEach{
            it.status = StudentStatuses.FINISH
        }
        studentRepository.saveAll(listStudents)
    }

}