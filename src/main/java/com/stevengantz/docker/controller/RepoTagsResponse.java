package com.stevengantz.docker.controller;

import java.util.List;

public class RepoTagsResponse {

	private int status;
	private String message;
	private List<String> tagList;
	
	public RepoTagsResponse(int status, String message, List<String> tagList) {
		this.tagList = tagList;
		this.message = message;
		this.status = status;
	}
	
	public RepoTagsResponse(int status, String message) {
		this.tagList = null;
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
	public List<String> getTagList() {
		return tagList;
	}
	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}
	
}
