package sim;

public class Test {
	public static void main(String args[]) {
		WallClock wallClock1 = new WallClock(12,0,true);
		System.out.println("WallClock1 time at midnight: \t\t" + wallClock1);
		
		WallClock wallClock2 = new WallClock(12,0,false);
		System.out.println("WallClock2 time at noon: \t\t" + wallClock2);
		
		WallClock wallClock3 = new WallClock(8,3,true);
		System.out.println("WallClock3 time at 8:03AM: \t\t" + wallClock3);
		
		WallClock wallClock4 = new WallClock(11,59,true);
		System.out.println("WallClock4 time at 11:59PM \t\t" + wallClock4);
		wallClock4.incrementTime();
		System.out.println("WallClock4 time at 12:00AM \t\t" + wallClock4);
		
		
		WallClockToMilitaryTime militaryTimeAdapter = new WallClockToMilitaryTime(wallClock1);
		System.out.println("" + militaryTimeAdapter.getTime());
		
		militaryTimeAdapter = new WallClockToMilitaryTime(wallClock2);
		System.out.println("" + militaryTimeAdapter.getTime());
		
		militaryTimeAdapter = new WallClockToMilitaryTime(wallClock3);
		System.out.println("" + militaryTimeAdapter.getTime());
		
		militaryTimeAdapter = new WallClockToMilitaryTime(wallClock4);
		System.out.println("" + militaryTimeAdapter.getTime());
		
	}
	
}
