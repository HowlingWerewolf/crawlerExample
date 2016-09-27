package example.crawllinkstodb.controller;

import java.util.Random;

public class Dice {
	
	int side;
	
	public Dice(int side) {
		this.side = side;
	}

	public int roll(int howManyTimesToRoll) {
		Random rand = new Random();
		
		int rollValue = 0;
		
		for (int i = 0; i < howManyTimesToRoll; i++){
			rollValue += rand.nextInt(side) + 1;
		}
		return rollValue;
	}
}
