package com.core.services;

import java.util.List;

import com.core.bo.Student;

public interface IStudentService {

	public void createNewStudent(Student pStudent);

	public void updateStudent(Student pStudent);

	public void deleteStudent(Long pId);

	public List<Student> getAllStudents();

	public List<Student> getStudentByName(String pName);

	public Student getStudentByCne(String pCne);

	public Student getStudentById(Long pId);

	public List<Student> multiCriteriaSearch(Student student);

}
