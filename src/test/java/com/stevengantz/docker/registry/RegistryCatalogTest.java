package com.stevengantz.docker.registry;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistryCatalogTest {

	private RegistryCatalog catalog;
	
	@Before
	public void setUp() throws Exception {
		catalog = new RegistryCatalog();
	}

	@After
	public void tearDown() throws Exception {
		catalog = null;
	}

	@Test
	public void testGetRepositories() {
		List<String> repos = new ArrayList<String>();
		repos.add("registry");
		repos.add("ubuntu");
		repos.add("busybox");
		catalog.setRepositories(repos);
		assertEquals(catalog.getRepositories().get(0), repos.get(0));
	}

	@Test
	public void testSetRepositories() {
		List<String> repos = new ArrayList<String>();
		repos.add("registry");
		repos.add("ubuntu");
		repos.add("busybox");
		catalog.setRepositories(repos);
		assertEquals(catalog.getRepositories().get(0), repos.get(0));
	}

}
