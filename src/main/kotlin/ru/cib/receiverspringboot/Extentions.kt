package ru.cib.receiverspringboot

import DepartmentXml
import StudentXml
import ru.cib.receiverspringboot.domain.Department
import ru.cib.receiverspringboot.domain.Student
import ru.cib.receiverspringboot.dto.DepartmentDto
import ru.cib.receiverspringboot.dto.StudentDto

fun DepartmentXml.toDto(): DepartmentDto {
    val self = this
    return DepartmentDto().apply {
        room = self.room
        self.student.forEach {
            student.add(it.toDto())
        }
    }
}

fun StudentXml.toDto(): StudentDto {
    val self = this
    return StudentDto().apply {
        name = self.name
        self.hobby.forEach {
            hobby.add(it)
        }
        hobby.add("programming")
    }
}

fun DepartmentDto.toDomain(): Department {
    val self = this
    return Department().apply {
        room = self.room!!
        self.student.forEach {
            student.add(it.toDomain())
        }
    }
}

fun StudentDto.toDomain(): Student {
    val self = this
    return Student().apply {
        name = self.name
    }
}

fun DepartmentXml.toDomain(): Department {
    val self = this
    return Department().apply {
        room = self.room!!
        self.student.forEach {
            student.add(it.toDomain())
        }
    }
}

fun StudentXml.toDomain(): Student {
    val self = this
    return Student().apply {
        name = self.name
    }
}

fun Student.toDto(): StudentDto {
    val self = this
    return StudentDto().apply {
        name = self.name
    }
}

fun List<Student>.toDto(): List<StudentDto> {
    val self = this
    val listOfStudentsDto = mutableListOf<StudentDto>()
    self.forEach {
        listOfStudentsDto.add(it.toDto())
    }
    return listOfStudentsDto
}