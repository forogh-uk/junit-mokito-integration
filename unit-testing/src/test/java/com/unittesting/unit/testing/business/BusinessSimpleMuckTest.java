package com.unittesting.unit.testing.business;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.unittesting.unit.testing.data.SomeDataService;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class BusinessSimpleMuckTest {
	
	@InjectMocks
	BusinessSimpleImpl bs;
	
	@Mock
	SomeDataService dataServiceMock;
	
	@BeforeEach
	public void before() {
		bs.setSomeData(dataServiceMock);
	}
	
	
	@Test
	@DisplayName("Calculate sum")
	public void calculateSumUsingDataService() {
		
		 //when some one call SomeDataService retriveAllData -> new int[] {1,2,3}
		 when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6,bs.calculateDataFromDataSerive());
	}
	
	
	@Test
	@DisplayName("Test with empty array")
	public void calculateSumEmptyArrayUsingDataServic() {
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});
		assertEquals(0,bs.calculateDataFromDataSerive());
	}
	
	@Test
	@DisplayName("Test with array one value")
	public void calculateSumOnevalueUsingDataServic() {
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1});
		int actual = bs.calculateDataFromDataSerive();
		int expected = 1;
		assertEquals(expected,actual);
	}

}
