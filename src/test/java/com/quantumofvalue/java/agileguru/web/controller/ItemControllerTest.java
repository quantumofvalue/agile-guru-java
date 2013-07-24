package com.quantumofvalue.java.agileguru.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import org.springframework.ui.ExtendedModelMap;

public class ItemControllerTest extends AbstractControllerTest {
	
	@Test
	public void testItemControllerReturnsTheCorrectView() throws Exception {
		
		ItemController itemController = new ItemController();
		
		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = itemController.list(uiModel);

		assertNotNull(result);
		assertEquals("items/list", result );
	}	
}
