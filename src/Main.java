
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws Exception {
		ParkingLot groupA = new ParkingLot(10, 20, 30);
		ParkingLot groupB = new ParkingLot(20, 30, 10);
		
		Scanner scan = new Scanner(new File("parking-lot-info-5.txt"));
		while (scan.hasNextLine()) {
				String carType = scan.nextLine();
				
				Car add;
				if (carType.equals("Sedan"))
					add = new Sedan();
				else if (carType.equals("SUV")) 
					add = new SUV();
				else
					add = new Truck();

				if (add instanceof Sedan && groupA.getSedanCost() < groupB.getSedanCost())
					groupA.park(add);
				else if (add instanceof Sedan)
					groupB.park(add);
				else if (add instanceof SUV && groupA.getSuvCost()() < groupB.getSuvCost())
					groupA.park(add);
				else if (add instanceof SUV)
					groupB.park(add);
				else if (add instanceof Truck && groupA.getTruckCost() < groupB.getTruckCost())
					groupA.park(add);
				else if (add instanceof Truck)
					groupB.park(add);
				
				groupA.tick();
				groupB.tick();
		}
		
		System.out.println("Group A made $" + groupA.getMoney());
		System.out.println("Group B made $" + groupB.getMoney());
	}
	
}
