package com.unittesting.unit.testing.business;


import com.unittesting.unit.testing.data.ItemRepository;
import com.unittesting.unit.testing.model.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceMockTest {
	
	@InjectMocks
	ItemBusinessService itemBusinessService;
	
	@Mock
	ItemRepository itemRepository;
	

	
	
	@Test
	@DisplayName("Calculate sum")
	public void retrieveAllItems() {
		
		when(itemRepository.findAll ()).thenReturn (
				Arrays.asList (new Item (2,"item2",10,10),
						new Item (3,"item3",20,20))
		);
		List<Item> items = itemBusinessService.retrieveAllItem ();
		assertEquals(100,items.get (0).getValue ());
		assertEquals (400,items.get (1).getValue ());


	}
	
	

	


}
