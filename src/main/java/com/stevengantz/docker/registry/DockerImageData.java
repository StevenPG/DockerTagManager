package com.stevengantz.docker.registry;

public class DockerImageData {

	private String registryName;
	private String imageName;
	private String tag;
	private ImageDigest digest;
	
	public String getRegistryName() {
		return registryName;
	}
	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public ImageDigest getDigest() {
		return digest;
	}
	public void setDigest(ImageDigest digest) {
		this.digest = digest;
	}
	
}
