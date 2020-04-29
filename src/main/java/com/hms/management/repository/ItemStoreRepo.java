package com.hms.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.management.model.ItemStore;

public interface ItemStoreRepo extends JpaRepository<ItemStore, Integer>{

}
