
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws Exception {
		ParkingLot lot = new ParkingLot();
		
		Scanner scan = new Scanner(new File("parking-lot-info-5.txt"));
		while (scan.hasNextLine()) {
				String carType = scan.nextLine();
				
				if (carType.equals("Sedan"))
					lot.park(new Sedan());
				else if (carType.equals("SUV")) 
					lot.park(new SUV());
				else
					lot.park(new Truck());
				
				lot.tick();
		}
		
		System.out.println("Made $" + lot.getMoney());
	}
	
}
