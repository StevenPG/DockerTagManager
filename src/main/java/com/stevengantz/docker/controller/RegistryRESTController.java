package com.stevengantz.docker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This rest controller makes REST calls to configured docker registries
@RestController
@RequestMapping("/api/v1/{registry}")
public class RegistryRESTController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
}
