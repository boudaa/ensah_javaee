package com.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

import com.bo.Etudiant;
import com.dao.HibernateEtudiantDaoImpl;

public class TestProgram {
	public static void main(String[] args) {

		HibernateEtudiantDaoImpl dao = new HibernateEtudiantDaoImpl();

		try {
			// Création de deux objets Etudiant tansitoires
			Etudiant etd1 = new Etudiant();
			etd1.setNom("boudaa");
			etd1.setPrenom("Mohamed");
			etd1.setCin("A11111");
			etd1.setValeurCalculée(100);

			Etudiant etd2 = new Etudiant();
			etd2.setNom("boudaa");
			etd2.setPrenom("Tarik");
			etd2.setCin("B11111");
			etd2.setValeurCalculée(200);

			// enregister dans la base de données les deux objets (les rendre persistants)
			dao.save(etd1);
			dao.save(etd2);

			System.out.println("Etudiant sauvegardé, son id est " + etd1.getId());
			System.out.println("Etudiant sauvegardé, son id est " + etd2.getId());

			// Récupérer un étudiant par son identifiant de la base de données
			Etudiant etd3 = dao.findById(Long.valueOf(etd1.getId()));
			System.out.println("Etudiant bien récupé de la base de données " + etd3);

			// Supprimer un étudiant
			dao.delete(etd3.getId());

			// Méttre à jour le nom d'un étudiant
			etd2.setNom("Alami");
			// attacher à la session pour que les mises à jours prennent effet
			dao.update(etd2);

		} catch (Exception e) {

			// on affiche un message d'erreur

			System.out.println(e.getMessage());

		}

		// On affiche la liste des étudiants en base de données aynt le nom boudaa
		List<Etudiant> list = dao.finByName("boudaa");

		System.out.println("La liste des étudiants  ayant le nom boudaa");
		for (Etudiant it : list) {
			System.out.println(it);
		}

		// afficher à nouveau tous les enregistrement en base
		System.out.println("Les étudiants enregistrés en base de données après suppression : ");
		list = dao.findAll();
		for (Etudiant it : list) {
			System.out.println(it);
		}

		// afficher à nouveau tous les enregistrement en base
		System.out.println("Les étudiants enregistrés en base de données : ");
		list = dao.findAll();
		for (Etudiant it : list) {
			System.out.println(it);
		}

		System.out.println("Les étudiants ayant le nom & prénom tarik boudaa ");

		list = dao.findByCriteria("com.bo.Etudiant", new String[] { "nom", "prenom" },
				new String[] { "boudaa", "Tarik" });
		for (Etudiant it : list) {
			System.out.println(it);
		}

	}
}
