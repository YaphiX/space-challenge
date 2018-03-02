package ex;
import java.util.*;

public class Rocket implements SpaceShip{

	double price;
	int rocketWeight;
	int maxWeight;
	int weight;
	double launchBoomNum;
	double landBoomNum;
	
	Rocket(double price, int rocketWeight, int maxWeight, int weight) {
		this.price = price;
		this.rocketWeight = rocketWeight;
		this.maxWeight = maxWeight;
		this.weight = weight;
	}
	
	public boolean launch() {
		return true;
	}

	public boolean land() {
		return true;
	}

	public boolean canCarry(Item item) {
		if(item.weight + weight <= maxWeight) {
			return true;
		} else {
			return false;
		}
	}

	public int carry(Item item) {
		weight +=  item.weight;
		return weight;
	}
	
}
