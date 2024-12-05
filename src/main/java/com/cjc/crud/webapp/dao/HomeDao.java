package com.cjc.crud.webapp.dao;

import java.util.List;

import com.cjc.crud.webapp.model.Student;

public interface HomeDao {

	public void saveStudent(Student s);

	public List<Student> logincheck(String un, String ps);

	public List<Student> deleteData(int rollno);
	
	public Student editData(int rollno);

	public List<Student> updateData(Student s);

}
