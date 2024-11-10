package sim;
//Client
public class WallClock implements TimePiece{
	private int hour;
	private int minutes;
	private boolean isMorning;
	
	public WallClock() {
		hour = 0;
		minutes = 0;
		isMorning = true;
	}
	
	public WallClock(int hour, int minutes, boolean isMorning) {
		this.hour = hour;
		this.minutes = minutes;
		this.isMorning = isMorning;
	}
	
	// SETTERS AND GETTERS
	
	public int getHour() {
		return hour;
	}
	
	public boolean isMorning() {
		return isMorning;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public String getTime() {
		return String.format("%02d:%02d %s", hour, minutes, (isMorning ? "AM" : "PM"));
	}

	@Override
	public void setTime(int hour, int minutes, boolean isMorning) {
		// TODO Auto-generated method stub
		
	}

	public void incrementTime() {
		if(minutes++ != 60) {
			return;
		}else if(hour++ != 13) {
			minutes = 0;
			return;
		}else if(hour == 12){
			minutes = 0;
			isMorning = !isMorning;
		}else {
			minutes = 0;
			hour = 1;
		}
	}
	
	
}
