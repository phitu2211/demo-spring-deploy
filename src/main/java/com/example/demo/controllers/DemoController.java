package com.example.demo.controllers;

import com.example.models.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
  @GetMapping("/hello")
  public ResponseEntity<List<Student>> hello() {
    List<Student> students = new ArrayList<>();
    students.add(new Student(1L, "Anh", "phitu2211@gmail.com", 18));
    students.add(new Student(2L, "Phi", "phitu2211@gmail.com", 20));
    return ResponseEntity.ok(students);
  }

}