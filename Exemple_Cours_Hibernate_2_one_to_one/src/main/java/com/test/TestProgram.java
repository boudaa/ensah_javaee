package com.test;



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
		
		Adresse ad = new Adresse();
		ad.setVille("Imzouren");
		etd1.setAdresse(ad);
		
		dao.save(etd1);

	}
}
