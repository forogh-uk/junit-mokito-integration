package com.unittesting.unit.testing.controller;

import com.unittesting.unit.testing.business.ItemBusinessService;
import com.unittesting.unit.testing.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){

        return new Item(1,"Ball",10,100);
    }
@GetMapping("/dummy-item-from-business")
    public Item itemFromBusinessService(){
        return itemBusinessService.retreiveItem();
    }

    @GetMapping("/find-items-from-database")
    public List<Item> getItemsFromDatabases(){
        return itemBusinessService.retrieveAllItem ();

    }
}
