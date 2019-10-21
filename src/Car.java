
import java.sql.Timestamp;

public abstract class Car {
	
	private Timestamp ticket;
	protected int parkingSpot;
	
	public Car() {
		
	}
	
	public void park() {
		ticket = new Timestamp(System.currentTimeMillis());
	}
	
}
