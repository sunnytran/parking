
public class ParkingLot {
	
	public static final int SIZE = 100;
	
	public Car lot[];
	private int index;
	
	private int money;
	private final int SEDAN_COST = 10;
	private final int SUV_COST = 20;
	private final int TRUCK_COST = 30;
	
	public ParkingLot() {
		this.lot = new Car[SIZE];
		this.index = 0;
		
		this.money = 0;
	}
	
	public void park(Car car) {
		if (isFull()) {
			System.out.println("Parking lot is full");
			return;
		}
		
		car.park(index);
		lot[index++] = car;
	}
	
	public boolean isFull() {
		return index == SIZE;
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
