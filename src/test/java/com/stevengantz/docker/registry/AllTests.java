package com.stevengantz.docker.registry;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ImageTagsTest.class, 
	RegistryConnectionTest.class,
	ConfiguredRegistriesTest.class})
public class AllTests {

}
