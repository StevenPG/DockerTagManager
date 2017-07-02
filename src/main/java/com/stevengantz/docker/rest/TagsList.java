package com.stevengantz.docker.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Ignore all extra properties not configured below
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagsList {
	
	private String name;
	
	public TagsList() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "TagsList{name=" + this.name + "}";
	}
}
