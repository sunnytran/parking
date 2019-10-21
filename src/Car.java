
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

public abstract class Car {
	
	private Calendar ticket;
	private int timeLeft;
	protected int parkingSpot;
	
	public Car() {
		
	}
	
	public void park(int parkingSpot) {
		this.ticket = Calendar.getInstance();
		this.ticket.setTimeInMillis(new Timestamp(System.currentTimeMillis()).getTime());
		
		this.timeLeft = new Random().nextInt(12) + 1;
		
		this.parkingSpot = parkingSpot;
	}
	
	public void tick() {
		--timeLeft;
	}
	
	public Calendar getTicket() {
		return ticket;
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}
	
}
