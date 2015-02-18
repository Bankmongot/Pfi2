import java.util.Calendar;

public class ClockThread extends Thread {
	
	// links Clockthread class with interface class of ClockInterface
	private ClockInterface clockInterface;
	
	public ClockThread (ClockInterface ci) {
		this.clockInterface = ci;
	}
	
private boolean active = true;

@Override	
public void run() {	

}
}

