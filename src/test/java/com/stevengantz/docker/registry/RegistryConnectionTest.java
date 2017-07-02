package com.stevengantz.docker.registry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistryConnectionTest {

	private RegistryConnection api;
	
	@Before
	public void setUp() throws Exception {
		api = new RegistryConnection();
	}

	@After
	public void tearDown() throws Exception {
		api = null;
	}

	@Test
	public void testRegistryAPI() {
		assertNotNull(api);
	}

	@Test
	public void testGetTagsByRepoName() {
		ImageTags imgtags = api.getTagsByRepoName("registry");
		assertEquals("registry", imgtags.getName());
	}
	
	@Test
	public void testGetRegistryCatalog() {
		RegistryCatalog cat = new RegistryCatalog();
		List<String> repos = new ArrayList<String>();
		repos.add("registry");
		cat.setRepositories(repos);
		
		api.getRegistryCatalog("http://localhost:5000/v2/");
		
		assertEquals(cat.getRepositories().get(0), repos.get(0));
	}

}
