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
import com.stevengantz.docker.registry.ImageDigest;
import com.stevengantz.docker.registry.ImageTags;
import com.stevengantz.docker.registry.RegistryConnection;
import com.stevengantz.docker.registry.RegistryList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// This rest controller makes REST calls to configured docker registries
@RestController
@RequestMapping("/api/v1/")
@Api(value = "dockertagmanager", description = "REST Operations on Remote Docker Registries")
public class RegistryRESTController {

	// On controller initialization, load configured registries
	@Autowired
	private ConfiguredRegistries configs;

	@ApiOperation(value = "Return list of repositories (images) within supplied registry", response = RegistryCatalogResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 400, message = "Registry not found in configurations") })
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

	// list all tags of certain image
	@ApiOperation(value = "Return list of tags from supplied image within supplied registry", response = RepoTagsResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 400, message = "Image not found in configurations") })
	@RequestMapping(path = "/{registry}/{repo}/tags", method = RequestMethod.GET)
	public @ResponseBody RepoTagsResponse getTagsFromRepo(@PathVariable String registry, @PathVariable String repo) {
		RegistryConnection localConnection;
		try {
			localConnection = new RegistryConnection(configs.getURLFromName(registry));
			ImageTags repoTags = localConnection.getTagsByRepoName(repo);
			return new RepoTagsResponse(HttpServletResponse.SC_OK, "Successfully retrieved images from registry.",
					repoTags.getTags());
		} catch (RegistryNotFoundException e) {
			return new RepoTagsResponse(HttpServletResponse.SC_BAD_REQUEST,
					"Image " + repo + " not found in configurations.");
		}
	}

	// get digest of specific image and tag
	@ApiOperation(value = "Return image digest of supplied image:tag found in supplied repository", response = DigestResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved digest"),
			@ApiResponse(code = 400, message = "Image:Tag not found in configurations") })
	@RequestMapping(path = "/{registry}/{repo}/{tag}/id", method = RequestMethod.GET)
	public @ResponseBody DigestResponse getDigestFromImageTag(@PathVariable String registry, @PathVariable String repo, @PathVariable String tag) {
		RegistryConnection localConnection;
		try {
			localConnection = new RegistryConnection(configs.getURLFromName(registry));
			return new DigestResponse(HttpServletResponse.SC_OK, "Successfully retrieved image digest.", new ImageDigest(localConnection.getImageID(repo, tag)));
		} catch (RegistryNotFoundException e) {
			// TODO Auto-generated catch block
			return new DigestResponse(HttpServletResponse.SC_BAD_REQUEST, "Failed to retrieve image digest.");		
		}
	}

	@ApiOperation(value = "Return images matching supplied digest found in supplied repository", response = List.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved matching objects"),
			@ApiResponse(code = 400, message = "Matched images not found in supplied repository with supplied digest") })
	// TODO - Change from List<String> to JSON object
	// Pass in digest only in specific registry, get images and tags back that match
	@RequestMapping(path = "/{registry}/{id}/matches", method = RequestMethod.GET)
	public @ResponseBody List<String> getImagesFromIDAndRegistry(@PathVariable String registry,
			@PathVariable String id) {
		return null;
	}

	// TODO - Add swagger information to class
	// TODO - Change from List<String> to JSON object
	// Pass in only digest, get images and tags back that much from all repos
	@RequestMapping(path = "/registries/{id}/objects", method = RequestMethod.GET)
	public @ResponseBody List<String> getImagesFromID(@PathVariable String id) {
		return null;
	}

	@ApiOperation(value = "Return list of all configured registries", response = RegistryListResponse.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved registries"),
			@ApiResponse(code = 400, message = "No configured registries found") })
	// Pass in nothing, get list of registry names as JSON/Text Array
	@RequestMapping(path = "/registries", method = RequestMethod.GET)
	public @ResponseBody RegistryListResponse getConfiguredRegistries() {
		List<RegistryItem> items = configs.getItems();
		List<String> registryNames = new LinkedList<String>();
		for (RegistryItem item : items) {
			registryNames.add(item.getRegistryLabel());
		}
		return new RegistryListResponse(HttpServletResponse.SC_OK, "Successfully retrieved list of registries.", new RegistryList(registryNames));
	}

}
