
public class ClockLogic implements ClockInterface {
	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;

	// "Links" the GUI class with ClockLogic
	public void ClockGUI (DigitalClockGUI clockIn) {
		this.clockGUI = clockIn;
	}
	
	
	public void setAlarm(int hours, int minutes) {
		this.alarmHour = hours;
		this.alarmMinute = minutes;
	}

	@Override
	public void update(int hours, int minutes, int seconds) {
		
	}
	
	void clearAlarm() {
		
	}

}
