package com.quantumofvalue.java.agileguru.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/items")
@Controller
public class ItemController {

	final Logger logger = LoggerFactory.getLogger(ItemController.class);	
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		logger.info("Listing items");

		return "items/list";
	}
}
