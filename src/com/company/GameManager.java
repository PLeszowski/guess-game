package com.company;

import java.util.Scanner;

/**
 * Created by zz9ffd on 2017-06-08.
 */
public class GameManager {

	private static GameManager instance = null;
	private int count = 0;

	private GameManager(){
	}

	public static GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	}

	private Player hp = new HumanPlayer();
	private Player cp = new CPUPlayer();

	public int getCount() {
		return count;
	}

	public Player selectPlayer() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Who guesses? press c for cpu, h for human");
		String playerChoice = sc.nextLine();

		Player player;
		if (playerChoice.equals("c")) {
			player = cp;
		} else {
			player = hp;
		}
		return player;

	}

	public void play(Player player){

		int secretNumber;
		int guessNumber=0;
		int low = 1;
		int high = 100;

		if (player.equals(hp)){
			System.out.println(cp.getName() + ", enter number between " + low + " and " + high);
			secretNumber = cp.chooseNumber(low, high);
		}
		else{
			System.out.println(hp.getName() + ", enter number between " + low + " and " + high);
			secretNumber = hp.chooseNumber(low, high);
		}


		while (guessNumber != secretNumber){

			this.count++;

			while (guessNumber < low || guessNumber > high) {
				System.out.println(player.getName() + ", guess a number between " + low + " and " + high);
				guessNumber = player.chooseNumber(low, high);
			}

			if(guessNumber > secretNumber){
				high = guessNumber-1;
				System.out.println("Your number is too high");
			}
			else if (guessNumber < secretNumber){
				low = guessNumber+1;
				System.out.println("Your number is too low");
			}
			else{
				System.out.println("Number guessed");
			}

		}

		if(this.count < 8){
			System.out.println(player.getName() + ", you win with " + this.count + " tries");
		}
		else{
			int diff = count - 7;
			System.out.println(player.getName() + ", you loose! 7 tries exceeded by " + diff);
		}


	}



}