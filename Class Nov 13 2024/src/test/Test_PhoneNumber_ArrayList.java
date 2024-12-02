package test;

import java.util.ArrayList;

import sim.PhoneNumber;

public class Test_PhoneNumber_ArrayList {

	public static void main(String[] args) {
		ArrayList<PhoneNumber> list = new ArrayList<>();
		
		list.add(new PhoneNumber(876,789,2202));
		list.add(new PhoneNumber(856,789,2202));
		list.add(new PhoneNumber(896,789,2202));
		list.add(new PhoneNumber(876,700,2202));
		list.add(new PhoneNumber(876,800,2202));
		list.add(new PhoneNumber(876,800,4533));
		list.add(new PhoneNumber(856,789,1000));
		list.add(new PhoneNumber(876,789,1200));
		list.sort(null);
		System.out.println(list.toString());

	}

}
