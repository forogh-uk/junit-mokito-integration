package com.unittesting.unit.testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

import com.unittesting.unit.testing.data.SomeDataService;
import org.junit.jupiter.api.Test;

public class BusinessSimpleStubTest {
	
	
	
	
class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retriveAllData() {
		
		return new int[] {1,2,3};
	}
	
}

class SomeDataServiceEmptyStub implements SomeDataService{

	@Override
	public int[] retriveAllData() {
		
		return new int[] {};
	}
	
}


class SomeDataServiceOneValueStub implements SomeDataService{

	@Override
	public int[] retriveAllData() {
		
		return new int[] {1};
	}
	
}

	
	@Test
	@DisplayName("Calculate sum")
	public void calculateSumUsingDataService() {
		BusinessSimpleImpl bs = new BusinessSimpleImpl();
		bs.setSomeData(new SomeDataServiceStub());
		int actual = bs.calculateDataFromDataSerive();
		int expected = 6;
		assertEquals(expected,actual);
	}
	
	
	@Test
	@DisplayName("Test with empty array")
	public void calculateSumEmptyArrayUsingDataServic() {
		BusinessSimpleImpl bs = new BusinessSimpleImpl();
		bs.setSomeData(new SomeDataServiceEmptyStub());
		int actual = bs.calculateDataFromDataSerive();
		int expected = 0;
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("Test with array one value")
	public void calculateSumOnevalueUsingDataServic() {
		BusinessSimpleImpl bs = new BusinessSimpleImpl();
		bs.setSomeData(new SomeDataServiceOneValueStub());
		int actual = bs.calculateDataFromDataSerive();
		int expected = 1;
		assertEquals(expected,actual);
	}

}
