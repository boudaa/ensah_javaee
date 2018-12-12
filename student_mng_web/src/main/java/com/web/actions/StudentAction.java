package com.web.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.core.bo.Student;
import com.core.services.IStudentService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ResultPath("/pages/")
public class StudentAction extends ActionSupport {

	private Student student;

	private List<Student> studentList;

	@Autowired
	private IStudentService studentService;

	public StudentAction() {
		System.out.println("StudentAction created");
	}

	@Action(value = "showAddStudentForm", results = { @Result(name = "success", location = "addStudentForm.jsp") })
	public String showAddStudentForm() {

		studentList = studentService.getAllStudents();

		return SUCCESS;
	}

	@Action(value = "showSearchForm", results = { @Result(name = "success", location = "searchForm.jsp") })
	public String showSearchForm() {

		return SUCCESS;
	}

	@Action(value = "searchStudent", results = { @Result(name = "success", location = "listStudents.jsp") })
	public String search() {

		studentList = studentService.multiCriteriaSearch(student);
		return SUCCESS;
	}

	@Action(value = "addStudent", results = { @Result(name = "success", location = "addStudentForm.jsp") })
	public String addStudent() {

		studentService.createNewStudent(student);
		studentList = studentService.getAllStudents();

		addActionMessage("Student added");

		return SUCCESS;
	}

	@Action(value = "listStudents", results = { @Result(name = "success", location = "listStudents.jsp") })
	public String listStudents() {

		studentList = studentService.getAllStudents();

		return SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> students) {
		this.studentList = students;
	}

}
