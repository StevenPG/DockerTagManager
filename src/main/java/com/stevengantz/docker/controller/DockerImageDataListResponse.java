package com.stevengantz.docker.controller;

import java.util.List;

import com.stevengantz.docker.registry.DockerImageData;

public class DockerImageDataListResponse {

	private int status;
	private String message;
	private List<DockerImageData> images;
	
	public DockerImageDataListResponse(int status, String message, List<DockerImageData> images) {
		this.images = images;
		this.message = message;
		this.status = status;
	}
	
	public DockerImageDataListResponse(int status, String message) {
		this.images = null;
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
	public List<DockerImageData> getImages() {
		return images;
	}
	public void setImages(List<DockerImageData> images) {
		this.images = images;
	}
	
}
