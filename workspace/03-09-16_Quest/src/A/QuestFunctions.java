package A;

import java.util.Random;

public final class QuestFunctions {

	public static int getRandomNumber(int low, int high) {
		return new Random().nextInt(high-low+1)+low;
	}
	
	
}
