package com.ensah.core.dao;
import java.util.List;
import com.ensah.core.bo.Person;
public interface IPersonDaoCustom   {	
    List<Person> getPersonsByFirstName(String firstName);
    //d'autres méthodes 
}

