package com.unittesting.unit.testing.business;

import com.unittesting.unit.testing.data.ItemRepository;
import com.unittesting.unit.testing.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retreiveItem() {
        return new Item (1,"Ball",10,100);

    }

    public List<Item> retrieveAllItem(){
        List<Item> items = itemRepository.findAll ();
        for(Item item:items){
            item.setValue (item.getPrice () * item.getQuantity ());
        }
       return items;
    }


}
