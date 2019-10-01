package com.youngprime.revenue.users.config;

import javax.enterprise.context.ApplicationScoped;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

@ApplicationScoped
@ConfigBundle("image-config")
public class ImageConfigProperties {

	@ConfigValue(watch = true)
	private String folder;
	@ConfigValue(watch = true)
	private boolean overwrite;
	@ConfigValue(watch = true)
	private String format;
	@ConfigValue(watch = true)
	private String resourceType;
	@ConfigValue(watch = true)
	private boolean uniqueFilename;
	
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public boolean isOverwrite() {
		return overwrite;
	}
	public void setOverwrite(boolean overwrite) {
		this.overwrite = overwrite;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public boolean isUniqueFilename() {
		return uniqueFilename;
	}
	public void setUniqueFilename(boolean uniqueFilename) {
		this.uniqueFilename = uniqueFilename;
	}
	
	
}
