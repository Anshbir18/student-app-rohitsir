package com.example.studentmanagementmain.services;

import com.example.studentmanagementmain.model.StudentInfoModel;
import com.example.studentmanagementmain.repository.StudentDataStore;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    public StudentDataStore studentDataStore; //make instance of datastore


    public String createStudent(final String studentName, final String studentAge,final String adhar, final String univ){
        String randomId = UUID.randomUUID().toString();
        StudentInfoModel studentInfoModel=studentDataStore.createStudent(randomId, studentName, studentAge,adhar,univ);
        return studentInfoModel.getId();
    }

    public StudentInfoModel getStudentById(final String id) throws BadRequestException {
        StudentInfoModel studentInfoModel=studentDataStore.getStudentById(id);

        if(studentInfoModel==null){
            throw new BadRequestException("Invalid User");
        }
        return studentInfoModel;
    }

    public ArrayList<StudentInfoModel> getSutdentsByUniversity(final String university) throws BadRequestException {
        ArrayList<StudentInfoModel> listOfStudents =studentDataStore.getListByUnivName(university);

        if(listOfStudents==null){
            throw new BadRequestException("Invalid Univ");
        }
        return listOfStudents;

    }
}
