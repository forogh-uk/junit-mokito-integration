package com.unittesting.unit.testing.data;

import com.unittesting.unit.testing.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
