package com.pucetec.students.controllers

import com.pucetec.students.dto.StudentRequest
import com.pucetec.students.dto.StudentResponse
import com.pucetec.students.entities.Student
import com.pucetec.students.services.StudentService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController (
    val studentService: StudentService
){
    val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/api/student")

    fun createStudent(
        @RequestBody
        request: StudentRequest
    ): StudentResponse {
        logger.info("Creating student ${request.name}")
        return studentService.createStudent(request)
    }

    @GetMapping("/api/student")
    fun getAllStudents(): List<StudentResponse> {
        logger.info("Retrieving all students")

        return studentService.getAllStudents()
    }
}
