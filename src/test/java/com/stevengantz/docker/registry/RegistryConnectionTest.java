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
	private String testURL = "http://10.0.75.1:5000/";
	
	@Before
	public void setUp() throws Exception {
		api = new RegistryConnection(testURL);
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
		
		assertNotNull(api);
		
		assertEquals(cat.getRepositories().get(0), api.getRegistryCatalog().getRepositories().get(0));
	}
	
	@Test
	public void testGetImageID() {
		assertEquals("sha256:c2a449c9f8344bc09d07c42839c6ea012ffb522456c52304175c0519ce7870d4", api.getImageID("registry", "latest"));
	}
}
