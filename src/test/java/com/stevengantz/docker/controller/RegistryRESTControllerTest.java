package com.stevengantz.docker.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class RegistryRESTControllerTest {
	
	@Test
	public void testImplicitConstructor() {
		assertNotNull(new RegistryRESTController());
	}

}
