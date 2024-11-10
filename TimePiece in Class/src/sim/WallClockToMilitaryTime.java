package sim;
//Adapter
public class WallClockToMilitaryTime implements TimePiece{
	private TimePiece timePiece;
	
	public WallClockToMilitaryTime(TimePiece timePiece) {
		this.timePiece = timePiece;
	}

	public void incrementTime() {
		timePiece.incrementTime();
	}
	@Override
	public int getHour() {
		// TODO Auto-generated method stub
		return timePiece.getHour();
	}
	@Override
	public int getMinutes() {
		// TODO Auto-generated method stub
		return timePiece.getMinutes();
	}
	@Override
	public boolean isMorning() {
		// TODO Auto-generated method stub
		return timePiece.isMorning();
	}
	@Override
	public void setTime(int hour, int minutes, boolean morning) {
		timePiece.setTime(hour, minutes, morning);
	}

	@Override
	public String getTime() {
		int militaryHr = timePiece.getHour() + (timePiece.getHour() != 12 && !timePiece.isMorning()  ? 12 : 0);
		if(militaryHr == 24)
			militaryHr = 0;
		return String.format("%02d:%02d %s", militaryHr, timePiece.getMinutes());
	}
}
