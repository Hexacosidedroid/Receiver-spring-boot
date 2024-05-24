package ru.cib.receiverspringboot.service

import DepartmentXml
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.cib.receiverspringboot.configuration.JaxbConfig
import ru.cib.receiverspringboot.dto.DepartmentDto
import ru.cib.receiverspringboot.repository.DepartmentRepository
import ru.cib.receiverspringboot.repository.StudentRepository
import ru.cib.receiverspringboot.toDomain
import java.io.File
import java.lang.Exception

@Service
class FileService(
    private val jaxbConfig: JaxbConfig,
    private val departmentRepository: DepartmentRepository,
    private val studentRepository: StudentRepository,

) {

    @Scheduled(fixedDelay = 10000)
    fun searchAndSaveXml() {
        val listFiles =
            File("/Users/slava_ivanov_saikyo/IdeaProjects/Receiver-spring-boot/src/main/resources/new").listFiles()
        listFiles?.forEach {
            try {
                val departmentXml = jaxbConfig.createUnmarshaller()
                    .unmarshal(it.absoluteFile) as DepartmentXml
                val department = departmentXml.toDomain()
                departmentRepository.save(department)
                department.student.forEach {
                    studentRepository.save(it)
                }
                val xml = it.readText()
                File("/Users/slava_ivanov_saikyo/IdeaProjects/Receiver-spring-boot/src/main/resources/archive/${it.name}").writeText(xml)
                it.delete()
            } catch (e: Exception) {
                val xml = it.readText()
                File("/Users/slava_ivanov_saikyo/IdeaProjects/Receiver-spring-boot/src/main/resources/error/${it.name}").writeText(xml)
                it.delete()
            }
        }
    }

}