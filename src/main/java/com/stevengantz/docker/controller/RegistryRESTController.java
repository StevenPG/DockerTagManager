package com.stevengantz.docker.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stevengantz.docker.rest.PingResponse;

// This rest controller makes REST calls to configured docker registries
@RestController
@RequestMapping("/api/v1/{registry}")
public class RegistryRESTController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	/**
	 *  List all tags in a specified repository
	 * @return list of tags as JSON
	 */
	@RequestMapping(path = "/tagList", method = RequestMethod.GET)
	public String tagList() {
		return "Test";
	}
	
	/**
	 * Ping registry specified
	 * @param registry
	 * @return
	 */
	@RequestMapping(path = "/ping", method = RequestMethod.GET)
	public @ResponseBody PingResponse ping(@PathVariable String registry) {
		// Edge case if hitting the local registry
		if(registry.equals("local")) {
			String localRegistryAddr = env.getProperty("docker.registry.localhost");
			
			try {
				HttpURLConnection http = (HttpURLConnection) new URL(localRegistryAddr).openConnection();
				
				if(http.getResponseCode() == HttpURLConnection.HTTP_OK) {
					return new PingResponse(HttpServletResponse.SC_OK, "Successful ping of " + env.getProperty("docker.registry.localhost"));
				} else {
					return new PingResponse(HttpServletResponse.SC_BAD_REQUEST, "Something went wrong connecting to local registry.");
				}
			} catch (MalformedURLException e) {
				logger.error(e.getMessage());
				return new PingResponse(HttpServletResponse.SC_BAD_REQUEST, "Local Registry URL was incorrectly formatted in application configuration.");
				
			} catch (IOException e) {
				logger.error(e.getMessage());
				return new PingResponse(HttpServletResponse.SC_BAD_REQUEST, "IOException occurred attempting to connect to local registry.");
			}
			
		} else {
			
			
			
			return new PingResponse(HttpServletResponse.SC_BAD_REQUEST, "Registry does not exist within configuration.");
		}
	}
}
