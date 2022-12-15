package com.unittesting.unit.testing.controller.data;


import com.unittesting.unit.testing.data.ItemRepository;
import com.unittesting.unit.testing.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll(){
       List<Item> items= itemRepository.findAll();
       assertEquals(3,items.size ());

    }
}
