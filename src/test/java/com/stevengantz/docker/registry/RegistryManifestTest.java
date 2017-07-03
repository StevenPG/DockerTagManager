package com.stevengantz.docker.registry;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistryManifestTest {

	private RegistryManifest manifest; 
	
	@Before
	public void setUp() throws Exception {
		manifest = new RegistryManifest();
		RegistryManifestConfig maniConfig = new RegistryManifestConfig();
		maniConfig.setDigest("digest");
		manifest.setConfig(maniConfig);
	}

	@After
	public void tearDown() throws Exception {
		manifest = null;
	}

	@Test
	public void testGetConfig() {
		assertEquals(manifest.getConfig().getDigest(), "digest");
	}

	@Test
	public void testSetConfig() {
		RegistryManifestConfig maniConfig = new RegistryManifestConfig();
		maniConfig.setDigest("changedDigest");
		manifest.setConfig(maniConfig);
		assertEquals(manifest.getConfig().getDigest(), "changedDigest");
	}

}
