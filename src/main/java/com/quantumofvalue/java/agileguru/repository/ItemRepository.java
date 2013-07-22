package com.quantumofvalue.java.agileguru.repository;

import org.springframework.data.repository.CrudRepository;

import com.quantumofvalue.java.agileguru.domain.Item;


public interface ItemRepository extends CrudRepository<Item, Long> {
	
}
