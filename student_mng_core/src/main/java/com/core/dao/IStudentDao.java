package com.core.dao;

import java.util.Date;
import java.util.List;

import com.core.bo.Student;
import com.genericdao.api.GenericDao;

public interface IStudentDao extends GenericDao<Student, Long> {

	public Student getStudentByCne(String pCne);

	public List<Student> getSudentByName(String pName);

	public List<Student> getSudentMultiCriteria(String pName, String pPrenom, Date pDate, char gender);

}
