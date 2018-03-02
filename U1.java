package ex;
import java.util.*;

public class U1 extends Rocket{
	List<Item> carryThings = new ArrayList<Item>();
	
	U1(double price, int rocketWeight, int maxWeight, int weight) {
		super(price, rocketWeight, maxWeight, weight);
	}

	public boolean launch() {
		launchBoomNum = 0.05 * (new Double(weight - rocketWeight) / new Double(maxWeight));
		double randomNum = Math.random();
//		System.out.println(weight + " " + rocketWeight + " " + maxWeight);
//		System.out.println(randomNum + " " + launchBoomNum);
		if (randomNum >= 0 && randomNum <= launchBoomNum) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean land() {
		landBoomNum = 0.01 * (new Double(weight - rocketWeight) / new Double(maxWeight));
		double randomNum = Math.random();
//		System.out.println(randomNum + " " + landBoomNum);
		if (randomNum >= 0 && randomNum <= landBoomNum) {
			return false;
		} else {
			return true;
		}
	}
}
