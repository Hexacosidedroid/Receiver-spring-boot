package ru.cib.receiverspringboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.cib.receiverspringboot.domain.Student
import java.util.*

@Repository
interface StudentRepository:JpaRepository<Student, Int>