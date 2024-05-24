package ru.cib.receiverspringboot.domain

enum class StudentStatuses(val textStatus: String) {
    NEW("NEW"),
    PROCESSING("PROCESSING"),
    FINISH("FINISH")
}