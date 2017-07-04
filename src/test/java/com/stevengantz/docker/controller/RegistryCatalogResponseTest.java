package com.stevengantz.docker.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stevengantz.docker.registry.RegistryCatalog;

public class RegistryCatalogResponseTest {

	private RegistryCatalogResponse res;
	
	@Before
	public void setUp() throws Exception {
		res = new RegistryCatalogResponse(1, "test");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testRegistryCatalogResponse() {
		assertNotNull(new RegistryCatalogResponse(1, "test", new RegistryCatalog()));
	}
	
	@Test
	public void testRegistryCatalogResponseNoCatalog() {
		assertNotNull(new RegistryCatalogResponse(1, "test"));
	}

	@Test
	public void testGetStatus() {
		res = new RegistryCatalogResponse(1, "message");
		assertEquals(res.getStatus(), 1);
	}

	@Test
	public void testSetStatus() {
		res = new RegistryCatalogResponse(1, "message");
		res.setStatus(2);
		assertEquals(res.getStatus(), 2);
	}

	@Test
	public void testGetCatalog() {
		RegistryCatalog catalog = new RegistryCatalog();
		res = new RegistryCatalogResponse(1, "message", catalog);
		assertEquals(catalog, res.getCatalog());
	}

	@Test
	public void testSetCatalog() {
		RegistryCatalog catalog = new RegistryCatalog();
		res = new RegistryCatalogResponse(1, "message");
		res.setCatalog(catalog);
		assertEquals(catalog, res.getCatalog());
	}
	
	@Test
	public void testGetMessage() {
		res = new RegistryCatalogResponse(1, "message2");
		assertEquals(res.getMessage(), "message2");
	}

	@Test
	public void testSetMessage() {
		res = new RegistryCatalogResponse(1, "message");
		res.setMessage("message2");
		assertEquals(res.getMessage(), "message2");
	}

}
