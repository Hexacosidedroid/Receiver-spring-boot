package ru.cib.receiverspringboot.service

import org.springframework.stereotype.Service
import ru.cib.receiverspringboot.domain.Department
import ru.cib.receiverspringboot.repository.DepartmentRepository
import ru.cib.receiverspringboot.repository.StudentRepository
import ru.cib.receiverspringboot.toDomain
import java.lang.Exception

@Service
class DepartmentService(
    private val studentRepository: StudentRepository,
    private val departmentRepository: DepartmentRepository,
) {

    fun saveDepartmentInfo(departmentDomain: Department) = try {
            val savedDepartment = departmentRepository.save(departmentDomain)
            departmentDomain.student.forEach {
                studentRepository.save(it.apply {
                    department = savedDepartment
                })
            }
//        val selectDepartment = jdbcTemplate.query("SELECT * FROM student", RowMapper { rs, _ ->
//            rs.getString(1)
//        })
//        println(selectDepartment)
            true
        } catch (e: Exception) {
            false
        }
}