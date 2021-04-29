package com.bo;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ETUDIANT_TAB")
public class Etudiant {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@Column(name = "nom_etudiant", length = 50, nullable = false)
	private String nom;

	@Column(nullable = false, unique = true)
	private String cin;

	// Cette propriété est persistante, elle reçoit une configuration par défaut
	// (JPA utilise le principe de configuration par exception )
	private String prenom;
	// Un objet peut avoir des propriétés que l'on ne souhaite pas
	// rendre persistantes dans la base. Il faut alors impérativement les marquer
	// avec l'annotation avec @Transient.
	@Transient
	private int valeurCalculée;

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", cin=" + cin + ", prenom=" + prenom + ", valeurCalculée="
				+ valeurCalculée + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getValeurCalculée() {
		return valeurCalculée;
	}

	public void setValeurCalculée(int valeurCalculée) {
		this.valeurCalculée = valeurCalculée;
	}

}
