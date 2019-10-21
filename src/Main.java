
import java.util.Random;

public class Main {
	
	public static void main(String args[]) {
		ParkingLot lot = new ParkingLot();
		
		for (int i = 0; i < 1000; i++) {
			int carType = new Random().nextInt(3) + 1;
			
			if (carType == 1)
				lot.park(new Sedan());
			else if (carType == 2)
				lot.park(new SUV());
			else
				lot.park(new Truck());
		}
	}
	
}
