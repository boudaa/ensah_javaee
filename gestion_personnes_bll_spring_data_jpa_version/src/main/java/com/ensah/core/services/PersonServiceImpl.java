package com.ensah.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Person;
import com.ensah.core.dao.IPersonDao;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService {

	private IPersonDao personDao;

	@Autowired
	public PersonServiceImpl(IPersonDao pDao) {

		personDao = pDao;
		

	}

	public void addPerson(Person pPerson) {
		personDao.save(pPerson);
	}

	public List<Person> getAllPersons() {
		return personDao.findAll();
	}

	public void deletePerson(Long id) {
		personDao.deleteById(id);

	}

	public Person getPersonById(Long id) {
		return  personDao.findById(id).get();

	}

	public void updatePerson(Person pPerson) {
		personDao.save(pPerson);

	}

	public List<Person> getPersonsByFirstName(String pFirstName) {
		return personDao.getPersonsByFirstName(pFirstName);
	}

}
