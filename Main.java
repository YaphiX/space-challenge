package ex;

public class Main {
	public static void main(String[] args) {
		Simulation s11 = new Simulation("/ex/Phase-1.txt");
		Simulation s12 = new Simulation("/ex/Phase-2.txt");
		System.out.println("U1火箭第一阶段预算:" + s11.runSimulation(s11.loadU1(s11.loadItems(s11.in))) + "亿美元");
		System.out.println("U1火箭第二阶段预算:"+  s12.runSimulation(s12.loadU1(s12.loadItems(s12.in))) + "亿美元");
		
		Simulation s21 = new Simulation("/ex/Phase-1.txt");
		Simulation s22 = new Simulation("/ex/Phase-2.txt");
		System.out.println("U2火箭第一阶段预算:" + s21.runSimulation(s21.loadU2(s21.loadItems(s21.in))) + "亿美元");
		System.out.println("U2火箭第二阶段预算:"+  s22.runSimulation(s22.loadU2(s22.loadItems(s22.in))) + "亿美元");
	}
}
