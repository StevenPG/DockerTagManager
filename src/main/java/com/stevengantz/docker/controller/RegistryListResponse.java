package com.stevengantz.docker.controller;

import com.stevengantz.docker.registry.RegistryList;

public class RegistryListResponse {

	private int status;
	private String message;
	private RegistryList list;
	
	public RegistryListResponse(int status, String message, RegistryList list) {
		this.list = list;
		this.message = message;
		this.status = status;
	}
	
	public RegistryListResponse(int status, String message) {
		this.list = null;
		this.message = message;
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RegistryList getList() {
		return list;
	}

	public void setList(RegistryList list) {
		this.list = list;
	}

}
