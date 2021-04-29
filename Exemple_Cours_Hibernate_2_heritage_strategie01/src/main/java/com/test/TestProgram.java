package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bo.Etudiant;
import com.dao.HibernateEtudiantDaoImpl;

public class TestProgram {
	public static void main(String[] args) {

		HibernateEtudiantDaoImpl dao = new HibernateEtudiantDaoImpl();

		Etudiant etd = new Etudiant();
		etd.setNom("boudaa");
		etd.setPrenom("Mohamed");
		etd.setCin("A11111");
		etd.setCne("2222222");

		dao.save(etd);

	}
}
