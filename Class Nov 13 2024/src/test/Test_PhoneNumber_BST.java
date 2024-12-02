package test;

import java.util.TreeSet;

import sim.PhoneNumber;

public class Test_PhoneNumber_BST {

	public static void main(String[] args) {
		TreeSet<PhoneNumber> treeSet = new TreeSet<>();
		
		treeSet.add(new PhoneNumber(876,789,2202));
		treeSet.add(new PhoneNumber(856,789,2202));
		treeSet.add(new PhoneNumber(896,789,2202));
		treeSet.add(new PhoneNumber(876,700,2202));
		treeSet.add(new PhoneNumber(876,800,2202));
		treeSet.add(new PhoneNumber(876,800,4533));
		treeSet.add(new PhoneNumber(856,789,1000));
		treeSet.add(new PhoneNumber(876,789,1200));
		
		System.out.println(treeSet.toString());
	}

}
