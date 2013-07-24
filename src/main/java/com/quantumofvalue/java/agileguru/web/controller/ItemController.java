package com.quantumofvalue.java.agileguru.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.service.ItemService;

@RequestMapping("/items")
@Controller
public class ItemController {

	final Logger logger = LoggerFactory.getLogger(ItemController.class);	
	
	@Resource(name="itemService")
	private ItemService itemService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		logger.info("Listing items");	
		
		List<Item> items = itemService.findAll();
		uiModel.addAttribute("items", items);
		
		logger.info("No. of items: " + items.size());

		return "items/list";
	}
}