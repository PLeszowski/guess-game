package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by zz9ffd on 2017-06-08.
 */
public class HumanPlayer extends Player  {

	String name = "Human Player";

	Scanner sc = new Scanner(System.in);

	public HumanPlayer() {
	}

	@Override
	public int chooseNumber(int low, int high) {
		int number = 0;
		//try{
		number = sc.nextInt();
		//} catch (InputMismatchException e){
		//    System.out.println("value must contain only number");
		//}
		return number;
	}

	@Override
	public String getName() {
		return name;
	}
}