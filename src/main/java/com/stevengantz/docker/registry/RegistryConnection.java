package com.stevengantz.docker.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class RegistryConnection {

    private static final Logger log = LoggerFactory.getLogger(RegistryConnection.class);
    
    //TODO Temporary URL
    private static final String TEMPORARY_URL = "http://localhost:5000/v2/";
	
	public RegistryConnection() {	
	}
	
	public ImageTags getTagsByRepoName(String name) {
		RestTemplate restTemplate = new RestTemplate();
		// TODO - Pass URL into object, pull URL for RestTemplate
		return restTemplate.getForObject(TEMPORARY_URL + name + "/tags/list", ImageTags.class);
	}
	
	// TODO - Use URL for now, change now to use management bean, then pull URL
	public RegistryCatalog getRegistryCatalog(String URL) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(TEMPORARY_URL + "_catalog/", RegistryCatalog.class);
	}
	
}
