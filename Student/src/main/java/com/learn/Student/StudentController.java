package com.learn.Student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudent() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        log.info("REST request to save a school");
        studentService.saveStudent(student);
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> getStudent(@PathVariable("school-id") Long schoolId) {
        return ResponseEntity.ok(studentService.getStudentsBySchoolId(schoolId));
    }

}
