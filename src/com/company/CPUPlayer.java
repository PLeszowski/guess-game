package com.company;

import java.util.Random;

/**
 * Created by zz9ffd on 2017-06-08.
 */
public class CPUPlayer extends Player {

	String name = "CPU Player";

	public CPUPlayer() {
	}


	@Override
	public int chooseNumber(int low, int high) {

		int number;

		GameManager gm = GameManager.getInstance();

		if (high - low > 0) {
			Random random = new Random();
			number = random.nextInt(high - low) + low;
		} else {
			number = low;
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (gm.getCount() > 0)
			System.out.println("CPU: Number chosen " + number);
		else
			System.out.println("CPU: Secret number chosen ");

		return number;
	}

	@Override
	public String getName() {
		return name;
	}
}