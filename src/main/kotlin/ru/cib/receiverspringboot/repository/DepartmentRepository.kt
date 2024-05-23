package ru.cib.receiverspringboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.cib.receiverspringboot.domain.Department

@Repository
interface DepartmentRepository : JpaRepository<Department, Int>