package ru.cib.receiverspringboot.controller

import DepartmentXml
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.cib.receiverspringboot.configuration.JaxbConfig
import ru.cib.receiverspringboot.domain.Student
import ru.cib.receiverspringboot.dto.DepartmentDto
import ru.cib.receiverspringboot.repository.DepartmentRepository
import ru.cib.receiverspringboot.repository.StudentRepository
import ru.cib.receiverspringboot.service.DepartmentService
import ru.cib.receiverspringboot.toDomain
import ru.cib.receiverspringboot.toDto
import java.io.File

@RestController
class RestController(
    private val studentRepository: StudentRepository,
    private val departmentRepository: DepartmentRepository,
    private val departmentService: DepartmentService
) {
    @GetMapping("/getCount")
    fun getCount() = studentRepository.count()

    @GetMapping("/save/{name}")
    fun saveName(@PathVariable name: String): String {
        studentRepository.save(Student().apply {
            this.name = name
        })
        return "OK"
    }

    @DeleteMapping("/deleteDepartment/{id}")
    fun deleteDepartment(@PathVariable id: Int) : Boolean {
        departmentRepository.deleteById(id)
        return true
    }

    @PostMapping("/saveDepartmentInfo")
    fun saveDepartmentInfo(@RequestBody departmentDto: DepartmentDto) =
        departmentService.saveDepartmentInfo(departmentDto.toDomain())
}

