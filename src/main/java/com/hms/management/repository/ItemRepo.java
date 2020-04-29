package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{

}
