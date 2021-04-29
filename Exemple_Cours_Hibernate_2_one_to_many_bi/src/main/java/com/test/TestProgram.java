package com.test;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bo.Adresse;
import com.bo.Etudiant;
import com.dao.HibernateEtudiantDaoImpl;

public class TestProgram {
	public static void main(String[] args) {

		HibernateEtudiantDaoImpl dao = new HibernateEtudiantDaoImpl();

		// Création de deux objets Etudiant tansitoires
		Etudiant etd1 = new Etudiant();
		etd1.setNom("boudaa");
		etd1.setPrenom("Mohamed");
		etd1.setCin("A11111");
		
		Adresse ad0 = new Adresse();
		ad0.setVille("Imzouren");
		
		Adresse ad1 = new Adresse();
		ad1.setVille("Imzouren");
		
		Set<Adresse> ads = new HashSet<Adresse>();
		ads.add(ad0);
		ads.add(ad1);
		
		etd1.setAdresses(ads);
		
		dao.save(etd1);

	}
}
