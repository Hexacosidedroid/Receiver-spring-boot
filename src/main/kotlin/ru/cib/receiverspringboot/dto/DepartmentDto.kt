package ru.cib.receiverspringboot.dto

data class DepartmentDto(
    var room: String? = null,
    var student: MutableList<StudentDto> = mutableListOf()
)