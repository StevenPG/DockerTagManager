package com.stevengantz.docker.registry;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistryManifestConfigTest {

	private RegistryManifestConfig config;
	
	@Before
	public void setUp() throws Exception {
		config = new RegistryManifestConfig();
	}

	@After
	public void tearDown() throws Exception {
		config = null;
	}

	@Test
	public void testGetMediaType() {
		config.setMediaType("mediaType");
		assertEquals(config.getMediaType(), "mediaType");
	}

	@Test
	public void testSetMediaType() {
		config.setMediaType("mediaType");
		assertEquals(config.getMediaType(), "mediaType");
	}

	@Test
	public void testGetSize() {
		config.setSize("size");
		assertEquals(config.getSize(), "size");
	}

	@Test
	public void testSetSize() {
		config.setSize("size");
		assertEquals(config.getSize(), "size");
	}

	@Test
	public void testGetDigest() {
		config.setDigest("digest");
		assertEquals(config.getDigest(), "digest");
	}

	@Test
	public void testSetDigest() {
		config.setDigest("digest");
		assertEquals(config.getDigest(), "digest");
	}

}
