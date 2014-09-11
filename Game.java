package hangman;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		String word;
		int maxGuesses;
		
		int gamesPlayed = 0;
		
		boolean isRunning = true;
		boolean isPlaying = true;
		
		do {
			gamesPlayed++;
			System.out.println("Game number: " + gamesPlayed);
			
			// ask for input to start a game with
			System.out.println("Word? ");
			Scanner scanner = new Scanner(System.in);
			word = scanner.next();
			System.out.println("Number of guesses allowed? ");
			maxGuesses = scanner.nextInt();
			
			// start the game
			Hangman game = new Hangman(maxGuesses, word);
			
			do {
				isPlaying = true;
				game.drawState();
				System.out.println("guess: ");
				char guess = game.getChar();
				// if we haven't already guessed this char
				if (game.checkChar(guess)) {
					game.guessChar(guess);
				} else {
					System.out.println("You've already guessed that character!");
				}
				
				if (game.hasLost()) {
					isPlaying = false;
					System.out.println("u looz! >:))))");				
				} else if (game.hasWon()) {
					isPlaying = false;
					System.out.println("a winnar iz u!! :D :D :D");
				}
			} while (isPlaying);
			System.out.println("Do you want to play again? (Y/N) ");
			char response = game.getChar();
			if (response == 'y') { isRunning = true; } else { isRunning = false; }

		} while (isRunning);
	}	
}
