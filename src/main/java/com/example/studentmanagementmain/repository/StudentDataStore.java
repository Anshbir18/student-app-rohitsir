package com.example.studentmanagementmain.repository;
import com.example.studentmanagementmain.model.StudentInfoModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
@Component
public class StudentDataStore {

    private final Map<String, StudentInfoModel> studentDataMap; //<studentId,StudentInfoModel>
    private final Map<String, ArrayList<StudentInfoModel>> universityMap;//<university,list<student> >

    public StudentDataStore(){
        //initialization
        studentDataMap = new HashMap<>();
        universityMap = new HashMap<>();
    }

    public StudentInfoModel getStudentById(final String id) {
        return studentDataMap.getOrDefault(id, null); // if the value is not present then return null
    }
    public ArrayList<StudentInfoModel> getListByUnivName(final String univ){
        return universityMap.getOrDefault(univ,null);
    }

    public StudentInfoModel createStudent(final String id, final String name, final String age,final String adhar,final String univ) {
        StudentInfoModel newStudentDataModel = new StudentInfoModel(id, name, age, adhar, univ);// node* temp=new node(-1);
        studentDataMap.put(id, newStudentDataModel); // put method is used to add to map

        if(!universityMap.containsKey(univ)){
            universityMap.put(univ,new ArrayList<>());
        }
        universityMap.get(univ).add(newStudentDataModel);
        return  newStudentDataModel;
    }

}
