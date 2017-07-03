package com.stevengantz.docker.registry;

import org.springframework.web.client.RestTemplate;

public class RegistryConnection {
	
	private String registryURL;
	
	// TODO - Change to be name of registry configured, and retrieved within class
	public RegistryConnection(String registryURL) {	
		this.registryURL = registryURL;
	}
	
	public ImageTags getTagsByRepoName(String name) {
		RestTemplate restTemplate = new RestTemplate();
		// TODO - Pass URL into object, pull URL for RestTemplate
		return restTemplate.getForObject(registryURL + "v2/" + name + "/tags/list", ImageTags.class);
	}
	
	// TODO - Use URL for now, change now to use management bean, then pull URL
	public RegistryCatalog getRegistryCatalog(String URL) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(registryURL + "v2/_catalog/", RegistryCatalog.class);
	}
	
}
