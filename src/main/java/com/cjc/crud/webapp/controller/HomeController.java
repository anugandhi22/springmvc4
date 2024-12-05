package com.cjc.crud.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.crud.webapp.model.*;
import com.cjc.crud.webapp.dao.*;
import com.cjc.crud.webapp.daoimp.*;
import com.cjc.crud.webapp.service.*;
import com.cjc.crud.webapp.serviceimp.*;

@Controller
public class HomeController {
	@Autowired
	HomeService ssi;
@RequestMapping("/")
public String preLogin() {
	return "login";
}
@RequestMapping("/reg")
public String preRegister() {
	return "register";
}
@RequestMapping("/register")
public String saveStudent(@ModelAttribute Student s) {
	ssi.saveStudent(s);
return "login";	
}
@RequestMapping("/logIn")
public String logIn() {
	return "login";
}

@RequestMapping("/log")
public String logincheck(@RequestParam("uname") String un,@RequestParam("password") String ps,Model m) {
	List<Student> list=ssi.logincheck(un,ps);
	m.addAttribute("Student",list);
	return "success";
}
@RequestMapping("/delete")
public String deleteData(@RequestParam("rollno") int rollno,Model m) {
	List<Student> list=ssi.deleteData(rollno);
	m.addAttribute("Student", list);
	return "success";
	
}
@RequestMapping("/edit")
public String editData(@RequestParam("rollno") int rollno,Model m) {
	Student s=ssi.editData(rollno);
	m.addAttribute("Student", s);
	return "edit";
}
@RequestMapping("/update")
public String updateData(@ModelAttribute Student s,Model m) {
List<Student> list=ssi.updateData(s);
	
	m.addAttribute("Student",list);
	return "success";
}

}
