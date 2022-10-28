package com.yeahbutstill.springdemo.controller;

import com.yeahbutstill.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class StudentRestController {

    private List<Student> studentList;

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData() {

        studentList = new ArrayList<>();

        studentList.add(new Student("Dani", "Setiawan"));
        studentList.add(new Student("Maya", "Setiawan"));
        studentList.add(new Student("Winda", "Setiawan"));
        studentList.add(new Student("Yuni", "Setiawan"));

    }


    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

//        studentList = new ArrayList<>();
//
//        studentList.add(new Student("Dani", "Setiawan"));
//        studentList.add(new Student("Maya", "Setiawan"));
//        studentList.add(new Student("Winda", "Setiawan"));
//        studentList.add(new Student("Yuni", "Setiawan"));

        return studentList;

    }

    // define endpoint for "/students/{studentId}" - returnt student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // check the studentId against list size
        if ((studentId >= studentList.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return studentList.get(studentId);

    }

}
