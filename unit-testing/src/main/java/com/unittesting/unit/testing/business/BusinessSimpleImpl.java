package com.unittesting.unit.testing.business;

import com.unittesting.unit.testing.data.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class BusinessSimpleImpl {
	
	private SomeDataService someData;
	
	
	
	
	
	public void setSomeData(SomeDataService someData) {
		this.someData = someData;
	}

	public int calculateSum(int[] data) {

		/*
		int sum =0;
		for(int value: data) {
			sum = sum + value;
		}
		return sum;

		 */
		// we are using java 8 and use functional programming


		//1 -> create a stream from array data
		//OptionalInt number = Arrays.stream (data).reduce (Integer::sum);
		//		return  number.orElse (0);

		// we can also clean more

		return  Arrays.stream (data).reduce (Integer::sum).orElse (0);


	}
	
	
	
	
	public int calculateDataFromDataSerive() {

		/*
		int sum =0;
		int[] data = someData.retriveAllData();

		for(int value:data) {
			sum = sum + value;
		}
		//someDataService.store(sum) -> that is store and in test capture
		return sum;


	*/

		int[] data = someData.retriveAllData();

		return Arrays.stream (data).reduce (Integer::sum).orElse (0);

	}

}
