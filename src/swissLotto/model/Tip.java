package swissLotto.model;

import java.util.ArrayList;
import java.util.Random;

public class Tip extends ArrayList<Integer> {
	
	private static Random rand = new Random();
	//private boolean luckyBall;
	private static final int MAX_VALUE = 42;
	private static final int MAX_LUCKY_VALUE = 6;
	
	public Tip() {
		this.add(rand.nextInt(MAX_VALUE+1));
		this.add(rand.nextInt(MAX_VALUE+1));
		this.add(rand.nextInt(MAX_VALUE+1));
		this.add(rand.nextInt(MAX_VALUE+1));
		this.add(rand.nextInt(MAX_VALUE+1));
		this.add(rand.nextInt(MAX_VALUE+1));
		this.add(rand.nextInt(MAX_LUCKY_VALUE+1));
	}
}
