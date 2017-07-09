package com.stevengantz.docker.controller;

import com.stevengantz.docker.registry.ImageDigest;

public class DigestResponse {

	private int status;
	private String message;
	private ImageDigest digest;
	
	public DigestResponse(int status, String message, ImageDigest digest) {
		this.digest = digest;
		this.message = message;
		this.status = status;
	}
	
	public DigestResponse(int status, String message) {
		this.digest = null;
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

	public ImageDigest getDigest() {
		return digest;
	}

	public void setDigest(ImageDigest digest) {
		this.digest = digest;
	}
	
	
	
}
