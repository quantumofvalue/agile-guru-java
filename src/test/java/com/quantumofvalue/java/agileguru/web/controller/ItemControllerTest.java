package com.quantumofvalue.java.agileguru.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import org.springframework.ui.ExtendedModelMap;

import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.service.ItemService;

public class ItemControllerTest extends AbstractControllerTest {
	
	private final List<Item> items = new ArrayList<Item>();
	
	private ItemService itemService;
	
	private ItemController itemController;
	
	private void setUpItemService() {
		Item item = new Item("Test Item");
		item.setId(1l);
		items.add(item);
		
		itemService = mock(ItemService.class); 
		when(itemService.findAll()).thenReturn(items);
	}
	
	public void setUpController() {
		
		itemController = new ItemController();
		ReflectionTestUtils.setField(itemController, "itemService", itemService);
	}

	@Before
	public void setUp() {
		setUpItemService() ;
		setUpController();		
	}
	
	@Test
	public void testItemControllerReturnsTheCorrectView() throws Exception {
		
		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = itemController.list(uiModel);

		assertNotNull(result);
		assertEquals("items/list", result );
	}
	
	@Test 
	public void testItemControllerRetrievsTheItemsFromTheDatabase() throws Exception {
		
		ExtendedModelMap uiModel = new ExtendedModelMap();
		
		itemController.list(uiModel);
		
		@SuppressWarnings("unchecked")
		List<Item> modelItems = (List<Item>) uiModel.get("items");
		
		Assert.assertNotNull(modelItems);
		Assert.assertArrayEquals(items.toArray(), modelItems.toArray());		
	}
}
