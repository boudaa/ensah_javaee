package com.ensah.bo;

/**
 * This class stores messages exchanged between Views and Controllers
 * 
 * @author boudaa
 *
 */
public class Message {

	// Constants that define message type
	public static final int ERROR = 3;
	public static final int WARN = 2;
	public static final int INFO = 1;

	/** The texte of the message */
	private String text;

	/** The type of the message */
	private int type;

	public Message(String text, int type) {
		this.text = text;
		this.type = type;
	}

	@Override
	public String toString() {
		return text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
