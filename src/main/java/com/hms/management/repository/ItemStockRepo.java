package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.ItemStock;

public interface ItemStockRepo extends JpaRepository<ItemStock, Integer>{

}
