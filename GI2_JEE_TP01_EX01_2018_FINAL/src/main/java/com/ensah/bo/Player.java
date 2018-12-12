package com.ensah.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines the player
 * 
 * @author boudaa
 *
 */
public class Player {

	/** player id */
	private Long id;

	/** player name */
	private String nom;

	/** player login */
	private String login;

	/** player password */
	private String password;

	/** rounds played by this player */
	private List<GameRound> rounds = new ArrayList<GameRound>();

	/** reference to the current round started by this player */
	private GameRound currentRound;

	public Player(Long id, String nom, String login, String password) {
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}

	/**
	 * Computes the best score of the player
	 * 
	 * @return
	 */
	public double getPlayerBestScore() {

		List<GameRound> rounds = getRounds();
		double max = 0;
		for (GameRound it : rounds) {
			if (max < it.getRoundScore()) {
				max = it.getRoundScore();
			}
		}

		return max;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<GameRound> getRounds() {
		return rounds;
	}

	public void setRounds(List<GameRound> rounds) {
		this.rounds = rounds;
	}

	public GameRound getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(GameRound currentRound) {
		this.currentRound = currentRound;
	}

}
