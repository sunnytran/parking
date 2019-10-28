import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class ParkingLot {
	
	public static final int SIZE = 100;
	
	private Calendar currentTime;
	
	public ArrayList<Car> lot;
	
	private int money;
	private int sedanCost;
	private int suvCost;
	private int truckCost;
	
	public ParkingLot() {
		this(10, 20, 30);
	}
	
	public ParkingLot(int sedanCost, int suvCost, int truckCost) {
		this.sedanCost = sedanCost;
		this.suvCost = suvCost;
		this.truckCost = truckCost;
		
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
			money += sedanCost;
		else if (car instanceof SUV)
			money += suvCost;
		else if (car instanceof Truck)
			money += truckCost;
	}
	
	public boolean isFull() {
		return lot.size() == SIZE;
	}
	
	public int getMoney() {
		return money;
	}

	public int getSedanCost() {
		return sedanCost;
	}

	public int getSuvCost() {
		return suvCost;
	}

	public int getTruckCost() {
		return truckCost;
	}
	
}
