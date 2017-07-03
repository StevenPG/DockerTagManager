package com.stevengantz.docker.config;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistryItemTest {

	private RegistryItem reg;
	
	@Before
	public void setUp() throws Exception {
		reg = new RegistryItem();
	}

	@After
	public void tearDown() throws Exception {
		reg = null;
	}

	@Test
	public void testGetRegistryLabel() {
		reg.setRegistryLabel("testlabel");
		assertEquals("testlabel", reg.getRegistryLabel());
	}

	@Test
	public void testSetRegistryLabel() {
		reg.setRegistryLabel("testlabel");
		assertEquals("testlabel", reg.getRegistryLabel());
	}

	@Test
	public void testGetRegistryURL() {
		reg.setRegistryURL("testurl");
		assertEquals("testurl", reg.getRegistryURL());
	}

	@Test
	public void testSetRegistryURL() {
		reg.setRegistryURL("testurl");
		assertEquals("testurl", reg.getRegistryURL());
	}

}
