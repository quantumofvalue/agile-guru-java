package com.quantumofvalue.java.agileguru.service.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.service.ItemService;
import com.quantumofvalue.java.agileguru.test.annotation.DataSets;


public class ItemServiceImplTest extends AbstractServiceImplTest {

	@Autowired
	ItemService itemService;
	
	@DataSets(setUpDataSet="/com/quantumofvalue/java/agileguru/service/jpa/ItemServiceImplTest.xls")
	@Test
	public void testFindAll()
		throws Exception {

		List<Item> result = itemService.findAll();

		assertNotNull(result);
		assertEquals(2, result.size());
	}
		
//	@DataSets(setUpDataSet="/com/apress/prospring3/ch19/service/jpa/ItemEmpty.xls")
//	@Test
//	public void testAddContact()
//		throws Exception {
//
//		// Clear all existing data in Contact table
//		//deleteFromTables("CONTACT");
//		
//		Contact contact = new Contact();
//		contact.setFirstName("Rod");
//		contact.setLastName("Johnson");
//		LocalDateTime birthDate = LocalDateTime.parse("1978-10-25");
//		contact.setBirthDate(birthDate);
//
//		contact = customerService.save(contact);
//		em.flush();
//		
//		List<Contact> contacts = customerService.findAll();
//		assertEquals(1, contacts.size());
//		
//	}		

}