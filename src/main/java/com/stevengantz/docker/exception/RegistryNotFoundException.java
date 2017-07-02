package com.stevengantz.docker.exception;

public class RegistryNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RegistryNotFoundException() {
		super();
	}
	
	public RegistryNotFoundException(String message) {
		super(message);
	}
	
}
