package com.stevengantz.docker.registry;

public class ImageDigest {

	private String contents;

	public ImageDigest(String imageID) {
		this.contents = imageID;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
