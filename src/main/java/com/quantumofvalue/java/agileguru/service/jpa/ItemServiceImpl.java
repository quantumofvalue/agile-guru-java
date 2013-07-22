package com.quantumofvalue.java.agileguru.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.google.common.collect.Lists;
import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.repository.ItemRepository;
import com.quantumofvalue.java.agileguru.service.ItemService;

@Service("itemService")
@Repository
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Transactional(readOnly=true)
	public List<Item> findAll() {
		return Lists.newArrayList(itemRepository.findAll());
	}	
}
