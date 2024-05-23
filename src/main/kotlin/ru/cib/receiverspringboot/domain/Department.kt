package ru.cib.receiverspringboot.domain

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Table(name = "department")
@Entity
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,
    @Column(name = "room")
    var room: String = "",
    @OneToMany(mappedBy = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    var student: MutableList<Student> = mutableListOf()
)