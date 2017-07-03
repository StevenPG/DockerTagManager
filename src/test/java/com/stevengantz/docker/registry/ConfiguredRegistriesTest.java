package com.stevengantz.docker.registry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stevengantz.docker.config.ConfiguredRegistries;
import com.stevengantz.docker.config.RegistryItem;
import com.stevengantz.docker.exception.RegistryNotFoundException;

public class ConfiguredRegistriesTest {

	public ConfiguredRegistries cregs;
	
	public void addTestItems() {
		RegistryItem regi = new RegistryItem();
		regi.setRegistryLabel("test");
		regi.setRegistryURL("http://testurl.com");
		List<RegistryItem> itemList = new ArrayList<>();
		itemList.add(regi);
		cregs.setItems(itemList);
	}
	
	@Before
	public void setUp() throws Exception {
		cregs = new ConfiguredRegistries();
	}

	@After
	public void tearDown() throws Exception {
		cregs = null;
	}

	@Test
	public void testConfiguredRegistries() {
		assertNotNull(cregs);
	}

	@Test
	public void testToString() {
		assertEquals("ConfiguredRegistries: registries: {\"local\":\"http:\\/\\/10.0.75.1:5000\\/\"}, ", cregs.toString());
	}
	
	@Test
	public void testGetItems() {
		addTestItems();
		assertEquals(cregs.getItems().get(0).getRegistryLabel(), "test");
	}

	@Test
	public void testSetItems() {
		addTestItems();
		assertEquals(cregs.getItems().get(0).getRegistryLabel(), "test");
	}
	
	@Test
	public void testGetURLFromNameFound() throws Exception {
		addTestItems();
		try {
			assertEquals(cregs.getURLFromName("test"), "http://testurl.com");
		} catch (RegistryNotFoundException e) {
			throw new Exception();
		}
	}
	
	@Test(expected = RegistryNotFoundException.class)
	public void testGetURLFromNameNotFound() throws RegistryNotFoundException {
		addTestItems();
		cregs.getURLFromName("non-existant-name");
	}
}
