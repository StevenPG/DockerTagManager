package com.stevengantz.docker.registry;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageTags {

	private String name;
	private List<String> tags;

	public ImageTags() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(
				"ImageTags {" + 
				"name=" + this.name +
				", tags=");
		for(String tag : tags) {
			builder.append(tag + ", ");
		}
		builder.append("}");
		return builder.toString();
	}
	
}
