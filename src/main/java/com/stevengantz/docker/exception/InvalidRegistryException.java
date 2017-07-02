package com.stevengantz.docker.exception;

public class InvalidRegistryException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidRegistryException() {
		super();
	}
	
	public InvalidRegistryException(String message) {
		super(message);
	}
}
