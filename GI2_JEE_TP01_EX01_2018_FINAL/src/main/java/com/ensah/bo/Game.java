package com.ensah.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class wraps the game's data, including the players
 * 
 * @author boudaa
 *
 */
public class Game {

	/** Game players */
	private List<Player> users = new ArrayList<Player>();

	/** Method to compute the best score registered in the game */
	public Player getPlayerWithBestScore() {

		// assume that the first user is the best
		Player bestScorePlayer = users.get(0);

		// iterate over the list of users
		for (Player it : users) {

			// if is best to previous one
			if (it.getPlayerBestScore() > bestScorePlayer.getPlayerBestScore()) {
				bestScorePlayer = it;
			}

		}

		return bestScorePlayer;

	}

	/**
	 * Method to get a user by its login
	 * 
	 * @param pLogin
	 *            user login
	 * @return
	 */
	public Player getUserByLogin(String pLogin) {

		// We iterate over the user list
		for (Player it : users) {
			// if found
			if (pLogin != null && pLogin.equals(it.getLogin())) {
				return it;
			}
		}

		// if not found
		return null;

	}

	/**
	 * Method that allows to add a user in the game user list
	 * 
	 * @param u
	 *            the user to add
	 */
	public void addUser(Player u) {

		users.add(u);
	}

	public List<Player> getUsers() {
		return users;
	}

	public void setUsers(List<Player> users) {
		this.users = users;
	}

}
