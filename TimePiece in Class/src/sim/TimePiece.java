package sim;

public interface TimePiece {
	int getHour();
	int getMinutes();
	boolean isMorning();
	void setTime(int hour, int minutes, boolean morning);
	String getTime();
	void incrementTime();
}
