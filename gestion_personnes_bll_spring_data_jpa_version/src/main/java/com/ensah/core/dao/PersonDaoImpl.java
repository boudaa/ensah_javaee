package com.ensah.core.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.ensah.core.bo.Person;
public class PersonDaoImpl implements IPersonDaoCustom {
	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Person> getPersonsByFirstName(String firstName) {
		Query query = entityManager.createNativeQuery(
				"SELECT em.* FROM Person WHERE firstname LIKE ?", Person.class);
		query.setParameter(1, firstName + "%");
		return query.getResultList();
	}
    //d'autres méthodes 
}

