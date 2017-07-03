package com.stevengantz.docker.registry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistryManifest {

	// Retrieved from sending the Accept: {"Accept":"application/vnd.docker.distribution.manifest.v2+json"}
	// header over GET to a URL Ex: http://localhost:5000/v2/registry/manifests/2
	private RegistryManifestConfig config;

	public RegistryManifestConfig getConfig() {
		return config;
	}

	public void setConfig(RegistryManifestConfig config) {
		this.config = config;
	}
	
}
