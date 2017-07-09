package com.stevengantz.docker.registry;

import java.util.List;

public class RegistryList {

	private List<String> registries;

	public RegistryList(List<String> registryNames) {
		registries = registryNames;
	}

	public List<String> getRegistries() {
		return registries;
	}

	public void setRegistries(List<String> registries) {
		this.registries = registries;
	}
	
}
