package com.cjc.crud.webapp.service;

import java.util.List;

import com.cjc.crud.webapp.model.Student;

public interface HomeService {
public void saveStudent(Student s);

public List<Student> logincheck(String un, String ps);

public List<Student> deleteData(int rollno);


public Student editData(int rollno);

public List<Student> updateData(Student s);
}
