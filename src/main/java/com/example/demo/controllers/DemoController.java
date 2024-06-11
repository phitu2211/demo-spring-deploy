package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepo;
import java.util.List;
import java.util.Random;

@RestController
public class DemoController {
  @Autowired
  private StudentRepo repo;

  @GetMapping("/students")
  public ResponseEntity<List<Student>> listStudents() {
    return ResponseEntity.ok(repo.findAll());
  }

  public int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
  }

  @GetMapping("/student/create")
  public ResponseEntity<Student> create() {
    Student student = new Student();
    student.setAge(randInt(10, 100));
    student.setName("Anh " + randInt(100, 100000));
    student.setEmail(randInt(10, 500000) + "@gmail.com");
    repo.save(student);
    return ResponseEntity.ok(student);
  }

}