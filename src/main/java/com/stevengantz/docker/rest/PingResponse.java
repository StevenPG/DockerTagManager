package com.stevengantz.docker.rest;

/**
 * Contains status and message
 */
public class PingResponse {

	private int status;
	private String message;
	
	public PingResponse(int status, String message) {
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
}
