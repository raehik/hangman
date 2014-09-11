package hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
	public int state;
	public int maxGuesses;
	public int guessesMade;
	public String word;
	private List<Character> charsLeft = new ArrayList<Character>();
	public List<Character> guessedChars = new ArrayList<Character>();
	
	public Hangman(int maxGuesses, String word) {
		this.maxGuesses = maxGuesses;
		this.state = 1;
		this.word = word;
		
		for(char c : this.word.toCharArray()) {
		    this.charsLeft.add(c);
		}
	}
	
	public void drawState() {
		String asciiArt = null;
		
		switch (state) {
		case 1:
			asciiArt = "state 1";
			break;
		case 2:
			asciiArt = "state 2";
			break;
		case 3:
			asciiArt = "state 3";
			break;
		case 4:
			asciiArt = "state 4";
			break;
		case 5:
			asciiArt = "state 5";
			break;
		}
		
		System.out.println(asciiArt);
	}
	
	public char getChar() {
		String input;
		Scanner scanner = new Scanner(System.in);
		input = scanner.next();
		if (input.length() != 1) {
			return '_';
		} else {
			return input.charAt(0);
		}
	}
	
	public boolean guessChar(char guess) {
		if (this.charsLeft.contains(guess)) {
			this.charsLeft.remove(this.charsLeft.indexOf(guess));
			this.guessedChars.add(guess);
			return true;
	    } else {
	    	this.updateState();
			this.guessedChars.add(guess);
			return false;
		}
	}
	
	public boolean checkChar(char guess) {
		try {
			if (this.guessedChars.contains(guess)) {
				return false;
			} else {
				return true;
			}
		} catch (NullPointerException e) {
			// if no chars have been guessed yet, also return false
			return false;
		}
	}
	
	private boolean updateState() {
		// actually private
		if (this.state == this.maxGuesses) {
			return false;
		} else {
			this.state++;
			return true;
		}
	}
	
	public boolean hasLost() {
		return this.state == this.maxGuesses;
	}
	
	public boolean hasWon() {
		return charsLeft.isEmpty();
	}
}
