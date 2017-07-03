package com.stevengantz.docker.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class RegistryRESTControllerTest {
	
	@Test
	public void testImplicitConstructor() {
		assertNotNull(new RegistryRESTController());
	}
	
	@Test
	public void testGetReposInRegistry() {
		fail("Not yet implemented");
	}
	

}
