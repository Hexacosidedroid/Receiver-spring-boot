package ru.cib.receiverspringboot.domain

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Table(name = "students")
@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,
    @Column(name = "name")
    var name: String? = null,
    @ManyToOne(targetEntity = Department::class)
    @JoinColumn(name = "department_id")
    var department: Department? = null,
    var status: StudentStatuses = StudentStatuses.NEW
)
