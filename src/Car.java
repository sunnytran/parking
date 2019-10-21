
import java.sql.Timestamp;

public abstract class Car {
	
	private Timestamp ticket;
	protected int parkingSpot;
	
	private Timestamp leaveTime;
	
	public Car() {
//		int x = new Random().nextInt(5) + 1;
		
	}
	
	public void park(int parkingSpot) {
		this.ticket = new Timestamp(System.currentTimeMillis());
		this.parkingSpot = parkingSpot;
	}
	
	public void exit() {
		
	}
	
}
