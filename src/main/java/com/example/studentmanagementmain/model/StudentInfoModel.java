package com.example.studentmanagementmain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class StudentInfoModel {
    @Getter
    public String id;
    public String name;
    public String age;
    public String adhar;
    public String university;



}
