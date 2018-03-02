package ex;
import java.util.*;
import java.io.*;

public class Simulation {

	FileReader in = null;
	String path = "";
	Simulation(String _path) {
		this.path = Simulation.class.getResource(_path).getPath();
		try {
			this.in = new FileReader(this.path);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public List<Item> loadItems(FileReader in) {
		BufferedReader bf = new BufferedReader(in);
		String line = "";
		List<Item> itemList = new ArrayList<Item>();
		try {
			while((line=bf.readLine()) != null) {
				Item item = new Item(line.split("=")[0], Integer.parseInt(line.split("=")[1])/1000);
				itemList.add(item);
			}
//			for (Item i : itemList) {
//				System.out.println("name:" + i.name + " weight:" + i.weight);
//			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return itemList;
	}
	
	public List<Rocket> loadU1(List<Item> loadItems) {
		List<Rocket> u1RocketList = new ArrayList<Rocket>();
		U1 u = new U1(1, 10, 18, 10);
		for (int i = 0; i < loadItems.size(); i++) {
			Item cur = loadItems.get(i);
			if (u.canCarry(cur)) {
				u.carryThings.add(cur);
				u.carry(cur);
			} else {
				u1RocketList.add(u);
				u = new U1(1, 10, 18, 10);
				u.carryThings.add(cur);
				u.carry(cur);
			}
			if(i == loadItems.size()-1) {
				u1RocketList.add(u);
			}
		}
//		for(U1 u1 : u1RocketList) {
//			for(Item item : u1.carryThings) {
//				System.out.print(item.weight+ " ");
//			}
//			System.out.println();
//		}
		return u1RocketList;
	}
	
	public List<Rocket> loadU2(List<Item> loadItems) {
		List<Rocket> u2RocketList = new ArrayList<Rocket>();
		U2 u = new U2(1.2, 18, 29, 18);
		for (int i = 0; i < loadItems.size(); i++) {
			Item cur = loadItems.get(i);
			if (u.canCarry(cur)) {
				u.carryThings.add(cur);
				u.carry(cur);
			} else {
				u2RocketList.add(u);
				u = new U2(1.2, 18, 29, 18);
				u.carryThings.add(cur);
				u.carry(cur);
			}
			if(i == loadItems.size()-1) {
				u2RocketList.add(u);
			}
		}
//		for(U2 u2 : u2RocketList) {
//			for(Item item : u2.carryThings) {
//				System.out.print(item.weight+ " ");
//			}
//			System.out.println();
//		}
		return u2RocketList;
	}
	
	public double runSimulation(List<Rocket> rocketList) {
		double budget = 0;
		for (int i=0; i<rocketList.size(); i++) {
			Rocket r = rocketList.get(i);
			if(r.launch() == false || r.land() == false) {
				budget += r.price;
				i--;
			} else {
				budget += r.price;
			}
		}
		return budget;
	}	
}
