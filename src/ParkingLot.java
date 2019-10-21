import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class ParkingLot {
	
	public static final int SIZE = 100;
	
	private Calendar currentTime;
	
	public ArrayList<Car> lot;
	
	private int money;
	private final int SEDAN_COST = 10;
	private final int SUV_COST = 20;
	private final int TRUCK_COST = 30;
	
	public ParkingLot() {
		this.currentTime = Calendar.getInstance();
		this.currentTime.setTimeInMillis(new Timestamp(System.currentTimeMillis()).getTime());
		
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
		currentTime.add(Calendar.HOUR, 1);
		
		for (int i = 0; i < lot.size(); i++) {
			lot.get(i).tick();
			
			if (lot.get(i).getTimeLeft() <= 0) {
				System.out.println("Car left at spot " + i);

				exit(lot.get(i));
				lot.remove(i--);
			}
		}
	}
	
	public void exit(Car car) {
		if (car instanceof Sedan)
			money += SEDAN_COST;
		else if (car instanceof SUV)
			money += SUV_COST;
		else if (car instanceof Truck)
			money += TRUCK_COST;
	}
	
	public boolean isFull() {
		return lot.size() == SIZE;
	}
	
	public int getMoney() {
		return money;
	}
	
}
