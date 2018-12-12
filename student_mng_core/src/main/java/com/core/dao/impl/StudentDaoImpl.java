package com.core.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.bo.Student;
import com.core.dao.IStudentDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

@Repository
public class StudentDaoImpl extends HibernateSpringGenericDaoImpl<Student, Long> implements IStudentDao {

	public StudentDaoImpl() {
		super(Student.class);
	}

	@Override
	public Student getStudentByCne(String pCne) {

		Student result = null;
		List<Student> students = getEntityByColValue("Student", "cne", pCne);

		if (students != null && students.size() != 0) {
			result = students.get(0);
		}

		return result;
	}

	@Override
	public List<Student> getSudentByName(String pName) {
		List<Student> students = getEntityByColValue("Student", "nom", pName);
		return students;
	}

	@Override
	public List<Student> getSudentMultiCriteria(String pName, String pPrenom, Date pDate, char gender) {

		StringBuffer request = new StringBuffer("from Student where ");
		boolean opAnd = false;
		List<Object> values = new ArrayList<Object>();
		if (pName != null && !pName.isEmpty()) {
			opAnd = true;
			request.append("nom=?");
			values.add(pName);
		}

		if (pPrenom != null && !pPrenom.isEmpty()) {
			if (opAnd) {
				request.append(" and prenom=?");
			} else {
				request.append("  prenom=?");

			}
			opAnd = true;

			values.add(pPrenom);
		}

		if (pDate != null) {
			if (opAnd) {
				request.append(" and date=?");
			} else {
				request.append("  date=?");

			}
			opAnd = true;

			values.add(pDate);
		}
		if (gender == 'f' || gender == 'm') {
			if (opAnd) {
				request.append(" and gender=?");
			} else {
				request.append("  gender=?");

			}

			values.add(gender);
		}
		List<Student> l = (List<Student>) hibernateTemplate.find(request.toString(), values.toArray());

		// si aucun résultat trouvé
		if (l == null || l.size() == 0) {
			return new ArrayList<Student>();
		}

		return l;

	}

}
