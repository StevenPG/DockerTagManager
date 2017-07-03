package com.stevengantz.docker.registry;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.stevengantz.docker.config.RegistryItemTest;
import com.stevengantz.docker.controller.RegistryRESTControllerTest;

@RunWith(Suite.class)
@SuiteClasses({
	RegistryItemTest.class,
	RegistryRESTControllerTest.class,
	ConfiguredRegistriesTest.class,
	ImageTagsTest.class, 
	RegistryCatalogTest.class,
	RegistryConnectionTest.class,
	RegistryManifestTest.class,
	RegistryManifestConfigTest.class
	})
public class AllTests {

}
