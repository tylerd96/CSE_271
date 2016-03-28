package Stahr;

import java.util.Random;

public final class QuestFunctions {

	public static int getRandomNum(int low, int high) {
		Random rnd = new Random();
		return rnd.nextInt(high - low + 1) + low;
	}

}
