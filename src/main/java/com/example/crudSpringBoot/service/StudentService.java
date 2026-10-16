package com.example.crudSpringBoot.service;

import com.example.crudSpringBoot.entity.Student;
import com.example.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {  //This class perform only business logic

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentReq){
       Student studentResponse = studentRepository.save(studentReq);
       return studentResponse;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp=studentRepository.findById(id);
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        else{
            return null;
        }
    }

    public List<Student> getAllStudent(){
        List<Student> repsoneList=studentRepository.findAll();
        return repsoneList;
    }

    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent=studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToStore=existingStudent.get();
        studentToStore.setName(studentReq.getName());
        studentToStore.setEmail(studentReq.getEmail());
        studentToStore.setSubject(studentReq.getSubject());
        studentToStore.setRollNo(studentReq.getRollNo());
        studentToStore.setAge(studentReq.getAge());

        return studentRepository.save(studentToStore);
    }

    public Boolean deleteStudent(Long id){
        boolean isStudent=studentRepository.existsById(id);

        if(!isStudent) return false;

        studentRepository.deleteById(id);
        return true;
    }
}
