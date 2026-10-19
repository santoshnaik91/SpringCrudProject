package com.example.crudSpringBoot.controller;

import com.example.crudSpringBoot.entity.Student;
import com.example.crudSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //This class will recieve only the api https requests
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent=studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    //read one
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student studentResp=studentService.getStudent(id);
        if(studentResp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentResp);
    }

    //read all
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentsList=studentService.getAllStudent();
        if(studentsList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentsList);
    }

    //update
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,@RequestBody Student studentReq){
        Student studentResp=studentService.updateStudent(id,studentReq);
        if(studentResp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentResp);
    }

    //delete
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        boolean isDeleted=studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        boolean isDeleted=studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
}
