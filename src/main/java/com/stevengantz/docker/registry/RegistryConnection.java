package com.stevengantz.docker.registry;

import org.springframework.web.client.RestTemplate;

public class RegistryConnection {
    
    //TODO Temporary URL
    private static final String TEMPORARY_URL = "http://10.0.75.1:5000/";
	
	public RegistryConnection() {	
	}
	
	public ImageTags getTagsByRepoName(String name) {
		RestTemplate restTemplate = new RestTemplate();
		// TODO - Pass URL into object, pull URL for RestTemplate
		return restTemplate.getForObject(TEMPORARY_URL + "v2/" + name + "/tags/list", ImageTags.class);
	}
	
	// TODO - Use URL for now, change now to use management bean, then pull URL
	public RegistryCatalog getRegistryCatalog(String URL) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(TEMPORARY_URL + "v2/_catalog/", RegistryCatalog.class);
	}
	
}
