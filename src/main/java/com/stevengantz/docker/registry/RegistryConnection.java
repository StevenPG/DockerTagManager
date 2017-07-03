package com.stevengantz.docker.registry;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RegistryConnection {
	
	private String registryURL;
	
	// If the image was pushed with Docker Client 1.10 or above, you can obtain the image ID from the registry with
	// GET /v2/<image>/manifests/<tag> 
	// Your request must include the header
	// Accept: application/vnd.docker.distribution.manifest.v2+json
	// In the response, the image ID will be in the Content-Docker-Digest Response header.
	private final String imageIDRequiredHeader = "application/vnd.docker.distribution.manifest.v2+json";
	
	// TODO - Change to be name of registry configured, and retrieved within class
	public RegistryConnection(String registryURL) {	
		this.registryURL = registryURL;
	}
	
	/**
	 * Gives the list of all tags in supplied repo
	 * @param name
	 * @return
	 */
	public ImageTags getTagsByRepoName(String name) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(registryURL + "v2/" + name + "/tags/list", ImageTags.class);
	}
	
	/**
	 * Gives the list of repositories in the supplied registry
	 * @param URL
	 * @return
	 */
	public RegistryCatalog getRegistryCatalog(String URL) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(registryURL + "v2/_catalog/", RegistryCatalog.class);
	}
	
	// Connect to registry and retrieve/return ImageID
	/**
	 * Gives the imageid of a supplied image and tag
	 * @param repo - image
	 * @param tag - specific tag
	 * @return
	 */
	public String getImageID(String repo, String tag) {
		RestTemplate restTemplate = new RestTemplate();
		
		// As per https://stackoverflow.com/questions/21723183/spring-resttemplate-to-post-request-with-custom-headers-and-a-request-object
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Accept", imageIDRequiredHeader);
		
		HttpEntity<String> request = new HttpEntity<String>("getID", headers);
		
		// Get info back as JSON, only keep config/digest as info, return only digest as full string.
		ResponseEntity<RegistryManifest> manifest = restTemplate.exchange(
				registryURL + "v2/" + repo + "/manifests/" + tag,
				HttpMethod.GET, request, RegistryManifest.class);
		return manifest.getBody().getConfig().getDigest();
	}
	
}
