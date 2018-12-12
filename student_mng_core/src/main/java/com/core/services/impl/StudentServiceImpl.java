package com.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.bo.Student;
import com.core.dao.IStudentDao;
import com.core.services.IStudentService;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	
	

	public StudentServiceImpl() {

		System.out.println("studentDao " + studentDao);
	}

	@Override
	public List<Student> multiCriteriaSearch(Student student) {
		List<Student> result = new ArrayList<Student>();
		if (student.getCne() != null && !student.getCne().isEmpty()) {
			result.add(studentDao.getStudentByCne(student.getCne()));
			return result;
		}

		return studentDao.getSudentMultiCriteria(student.getNom(), student.getPrenom(), student.getDateNaissance(),
				student.getGender());

	}

	@Override
	public void createNewStudent(Student pStudent) {
		
		//Begin trans
		
		//TODO :  il faut gerer les regles metier pour ce service

		studentDao.create(pStudent);
		
		//commit
		
		//rollback
	}

	@Override
	public void updateStudent(Student pStudent) {

		//TODO : 
		studentDao.update(pStudent);
	}

	@Override
	public void deleteStudent(Long pId) {
		
		//TODO : 
		studentDao.delete(pId);
	}

	@Override
	public List<Student> getAllStudents() {
		
		
		return studentDao.getAll();
	}

	@Override
	public List<Student> getStudentByName(String pName) {
		return studentDao.getSudentByName(pName);
	}

	@Override
	public Student getStudentByCne(String pCne) {
		return studentDao.getStudentByCne(pCne);
	}

	@Override
	public Student getStudentById(Long pId) {
		return studentDao.findById(pId);
	}

}
