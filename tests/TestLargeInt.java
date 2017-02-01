package tests;

import java.util.ArrayList;

import general.LargeInt;

public class TestLargeInt {
	
	public static void testCreateSingleDigit(){
		LargeInt li = new LargeInt(1);		
		assert(li.ilist.size() == 1 && li.ilist.get(0) == 1);
	}
	
	public static void testCreateTwoDigit(){
		LargeInt li = new LargeInt(12);	
		assert(li.ilist.size() == 2 && li.ilist.get(0) == 1 && li.ilist.get(1) == 2);
	}
	
	public static void testCreateThreeDigit(){
		LargeInt li = new LargeInt(123);
		assert(li.ilist.size() == 3 && li.ilist.get(0) == 1 && li.ilist.get(1) == 2 && li.ilist.get(2) == 3);
	}
	
	public static void testAddEqualLength(){
		LargeInt li1 = new LargeInt(12);	
		LargeInt li2 = new LargeInt(24);
		li1.add(li2);
		assert(li1.equals(new LargeInt(36)));
	}
	
	public static void testAddSmaller(){
		LargeInt li1 = new LargeInt(123);		
		LargeInt li2 = new LargeInt(12);
		li1.add(li2);
		assert(li1.equals(new LargeInt(135)));

	}

	public static void testAddLarger(){
		LargeInt li1 = new LargeInt(12);		
		LargeInt li2 = new LargeInt(123);
		li1.add(li2);
		assert(li1.equals(new LargeInt(135)));
	}
	
	public static void testIncreaseLength(){
		LargeInt li1 = new LargeInt(99);		
		LargeInt li2 = new LargeInt(1);
		li1.add(li2);
		assert(li1.equals(new LargeInt(100)));
	}
	
	public static void testDigits(){
		LargeInt li1 = new LargeInt(Integer.MAX_VALUE);
		assert(li1.digits() == 10);
	}	
	
	public static void main(String[] args) {
		/* constructor */
		testCreateSingleDigit();
		testCreateTwoDigit();
		testCreateThreeDigit();
		
		/* add */
		testAddEqualLength();
		testAddSmaller();
		testAddLarger();
		testIncreaseLength();
		
		/* size */
		testDigits();
	}
}
