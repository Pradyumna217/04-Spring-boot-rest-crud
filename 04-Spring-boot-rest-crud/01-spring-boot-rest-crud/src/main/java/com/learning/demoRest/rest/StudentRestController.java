package com.learning.demoRest.rest;

import com.learning.demoRest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> ls;

//    Define @PostConstruct to load the data only once(load the data only once the bean is created

    @PostConstruct
    public void loadData(){

        ls = new ArrayList<>();
        ls.add(new Student("Pradyumna", "Deshmukh"));
        ls.add(new Student("Viraj", "Patil"));
        ls.add(new Student("Rushika", "Inamdar"));
    }
//    define endpoint for /student

    @GetMapping("/students")
    public List<Student> getStudents(){
        return ls;
    }

//    Define endpoint for retrieving the single student - return the student at index;

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId >= ls.size() || studentId < 0){
            throw new StudentNotFoundExecption("Student id not found" + studentId);
        }
        return ls.get(studentId);
    }


}
