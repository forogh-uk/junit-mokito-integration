package com.unittesting.unit.testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BusinessSimpleTest {
	


	
	@Test
	public void calculateSum() {
		BusinessSimpleImpl bs = new BusinessSimpleImpl();
		int actual = bs.calculateSum(new int[] {1,2,3});
		int expected = 6;
		assertEquals(expected,actual);
	}
	@Test
	@DisplayName("Test with empty array")
	public void calculateSum_empty_Array() {
		BusinessSimpleImpl bs = new BusinessSimpleImpl();
		int actual = bs.calculateSum(new int[] {});
		int expected = 0;
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test with array one value")
	public void calculateSum_One_value() {
		BusinessSimpleImpl bs = new BusinessSimpleImpl();
		int actual = bs.calculateSum(new int[] {1});
		int expected = 1;
		assertEquals(expected,actual);
	}

}
