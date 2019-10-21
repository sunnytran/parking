import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class ParkingLot {
	
	public static final int SIZE = 100;
	
	private Calendar cal;
	
	public ArrayList<Car> lot;
	
	private int money;
	private final int SEDAN_COST = 10;
	private final int SUV_COST = 20;
	private final int TRUCK_COST = 30;
	
	public ParkingLot() {
		this.cal = Calendar.getInstance();
		cal.setTimeInMillis(new Timestamp(System.currentTimeMillis()).getTime());
		
		this.lot = new ArrayList<Car>();
		
		this.money = 0;
	}
	
	public void park(Car car) {
		if (isFull()) {
//			System.out.println("Parking lot is full");
			return;
		}
		
		int spot = lot.size();
		System.out.println("Car parked at spot " + spot);
		
		car.park(spot);
		lot.add(car);
	}
	
	public void tick() {
		cal.add(Calendar.HOUR, 1);
	}
	
	public boolean isFull() {
		return lot.size() == SIZE;
	}
	
//	public void exit() {
//		if (car instanceof Sedan)
//			money += SEDAN_COST;
//		else if (car instanceof SUV)
//			money += SUV_COST;
//		else if (car instanceof Truck)
//			money += TRUCK_COST;
//	}
}
