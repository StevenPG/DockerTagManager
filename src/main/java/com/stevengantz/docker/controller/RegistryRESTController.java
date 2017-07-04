package com.stevengantz.docker.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stevengantz.docker.config.ConfiguredRegistries;
import com.stevengantz.docker.exception.RegistryNotFoundException;
import com.stevengantz.docker.registry.RegistryConnection;

// This rest controller makes REST calls to configured docker registries
@RestController
@RequestMapping("/api/v1/")
public class RegistryRESTController {

	// On controller initialization, load configured registries
	@Autowired
	private ConfiguredRegistries configs;

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
	
	

}
