package com.ensah.bo;

/**
 * This class defin a game round
 * 
 * @author boudaa
 *
 */
public class GameRound {

	// Constants that define the game state
	public static final int GAME_OVER = 0;
	public static final int GAME_STARTED = 1;

	// constant that define the number of possible attempts
	public static final int NUMBER_OF_ATTEMPTS = 20;

	/** store the previous result of dice throwing */
	private int previousRes;

	/** player owner of this round */
	private Player player;

	/** the final round score */
	private int roundScore;

	/** count the number throws of the dice */
	private int counter;

	/** the state of the game (started or over) */
	private int state;

	public GameRound() {

		// init with default values
		state = GAME_STARTED;
		counter = 0;
		roundScore = 0;
	}

	/** increments the counter of throws of the dice */
	public void incrementCounter() {
		counter++;
	}

	/** increase the score by 20 */
	public void increaseScore() {
		roundScore += 20;

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getRoundScore() {
		return roundScore;
	}

	public void setRoundScore(int roundScore) {
		this.roundScore = roundScore;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPreviousRes() {
		return previousRes;
	}

	public void setPreviousRes(int previousRes) {
		this.previousRes = previousRes;
	}

	public boolean isGameOver() {
		return state == GAME_OVER;
	}

}
