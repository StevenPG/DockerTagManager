package com.stevengantz.docker.controller;

import com.stevengantz.docker.registry.RegistryCatalog;

import io.swagger.annotations.ApiModelProperty;

public class RegistryCatalogResponse {

	private int status;
	private String message;
	private RegistryCatalog catalog;
	
	public RegistryCatalogResponse(int status, String message, RegistryCatalog catalog) {
		this.catalog = catalog;
		this.message = message;
		this.status = status;
	}
	
	public RegistryCatalogResponse(int status, String message) {
		this.catalog = null;
		this.message = message;
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public RegistryCatalog getCatalog() {
		return catalog;
	}
	public void setCatalog(RegistryCatalog catalog) {
		this.catalog = catalog;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
