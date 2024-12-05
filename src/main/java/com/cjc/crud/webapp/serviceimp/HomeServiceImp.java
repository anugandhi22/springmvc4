package com.cjc.crud.webapp.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.crud.webapp.dao.HomeDao;
import com.cjc.crud.webapp.model.Student;
import com.cjc.crud.webapp.service.HomeService;
@Service
public class HomeServiceImp  implements HomeService{
@Autowired
HomeDao sdi;
	@Override
	public void saveStudent(Student s) {
		sdi.saveStudent(s);
	}
	@Override
	public List<Student> logincheck(String un, String ps) {
		return sdi.logincheck(un,ps);
			}
	@Override
	public List<Student> deleteData(int rollno) {
				return sdi.deleteData(rollno);
	}
	@Override
	public Student editData(int rollno) {
	
		return sdi.editData(rollno);
	}
	@Override
	public List<Student> updateData(Student s) {
		
		return sdi.updateData(s);
	}
	
}
