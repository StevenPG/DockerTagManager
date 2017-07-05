package com.stevengantz.docker.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stevengantz.docker.config.ConfiguredRegistries;
import com.stevengantz.docker.config.RegistryItem;
import com.stevengantz.docker.exception.RegistryNotFoundException;
import com.stevengantz.docker.registry.ImageTags;
import com.stevengantz.docker.registry.RegistryConnection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// This rest controller makes REST calls to configured docker registries
@RestController
@RequestMapping("/api/v1/")
@Api(value="dockertagmanager", description="REST Operations on Remote Docker Registries")
public class RegistryRESTController {

	// On controller initialization, load configured registries
	@Autowired
	private ConfiguredRegistries configs;

	@ApiOperation(value = "Return list of repositories (images) within PathVariable: registry", 
			response = RegistryCatalogResponse.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 400, message = "Registry not found in configurations")
	})
	@RequestMapping(path = "/{registry}/repos", method = RequestMethod.GET)
	public @ResponseBody RegistryCatalogResponse getReposInRegistry(@PathVariable String registry) {
		RegistryConnection localConnection;
		try {
			localConnection = new RegistryConnection(configs.getURLFromName(registry));
			return new RegistryCatalogResponse(HttpServletResponse.SC_OK,
					"Successfully retrieved Repositories from Registry.", localConnection.getRegistryCatalog());
		} catch (RegistryNotFoundException e) {
			return new RegistryCatalogResponse(HttpServletResponse.SC_BAD_REQUEST,
					"Registry " + registry + " not found in configurations.");
		}
	}
	
	// TODO - Add swagger information to class
	// TODO - Change from List<String> to JSON object
	// list all tags of certain image
	@RequestMapping(path = "/{registry}/{repo}/tags", method = RequestMethod.GET)
	public @ResponseBody List<String> getTagsFromRepo(@PathVariable String registry, @PathVariable String repo){
		RegistryConnection localConnection;
		try {
			localConnection = new RegistryConnection(configs.getURLFromName(registry));
			ImageTags repoTags = localConnection.getTagsByRepoName(repo);
			return repoTags.getTags();
		} catch (RegistryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// TODO - Add swagger information to class
	// TODO - Change from List<String> to JSON object
	// get digest of specific image and tag
	@RequestMapping(path = "/{registry}/{repo}/{tag}/id", method = RequestMethod.GET)
	public @ResponseBody String getDigestFromImageTag(@PathVariable String registry, @PathVariable String repo, @PathVariable String tag) {
		RegistryConnection localConnection;
		try {
			localConnection = new RegistryConnection(configs.getURLFromName(registry));
			return localConnection.getImageID(repo, tag);
		} catch (RegistryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// TODO - Add swagger information to class
	// TODO - Change from List<String> to JSON object
	// Pass in digest only in specific registry, get images and tags back that match
	@RequestMapping(path = "/{registry}/{id}/objects", method = RequestMethod.GET)
	public @ResponseBody List<String> getImagesFromIDAndRegistry(@PathVariable String registry, @PathVariable String id){
		return null;
	}
	
	// TODO - Add swagger information to class
	// TODO - Change from List<String> to JSON object
	// Pass in only digest, get images and tags back that much from all repos
	@RequestMapping(path = "/registries/{id}/objects", method = RequestMethod.GET)
	public @ResponseBody List<String> getImagesFromID(@PathVariable String id){
		return null;
	}
	
	// TODO - Add swagger information to class
	// TODO - Change from List<String> to JSON object
	// Pass in nothing, get list of registry names as JSON/Text Array
	@RequestMapping(path = "/registries", method = RequestMethod.GET)
	public @ResponseBody List<String> getConfiguredRegistries(){
		List<RegistryItem> items = configs.getItems();
		List<String> registryNames = new LinkedList<String>();
		for(RegistryItem item : items) {
			registryNames.add(item.getRegistryLabel());
		}
		return registryNames;
	}

}
