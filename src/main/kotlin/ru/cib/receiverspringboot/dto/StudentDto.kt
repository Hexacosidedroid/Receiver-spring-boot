package ru.cib.receiverspringboot.dto

data class StudentDto(
    var name: String? = null,
    var hobby: MutableList<String> = mutableListOf()
)
