package com.example.studentmanagementmain.resources;

import com.example.studentmanagementmain.model.StudentInfoModel;
import com.example.studentmanagementmain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class Student {
    @Autowired

    private StudentService studentService;

    @GetMapping("/get/{id}")
    public StudentInfoModel getStudentById(@PathVariable String id)throws Exception{
        return studentService.getStudentById(id);
    }


    @GetMapping("/getStudents/{univ}")
    public ArrayList<StudentInfoModel> getStudents(@PathVariable String univ) throws Exception {
        return  studentService.getSutdentsByUniversity(univ);
    }

    @PostMapping("/create/{name}/{age}/{adhar}/{univ}")
        public String createEmployee(@PathVariable String name, @PathVariable String age,@PathVariable String adhar,@PathVariable String univ) {
            return studentService.createStudent(name, age,adhar,univ);
        }

}

