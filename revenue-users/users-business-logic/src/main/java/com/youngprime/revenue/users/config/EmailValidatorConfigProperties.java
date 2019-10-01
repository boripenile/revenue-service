package com.youngprime.revenue.users.config;

import javax.enterprise.context.ApplicationScoped;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

@ApplicationScoped
@ConfigBundle("email-validator-config")
public class EmailValidatorConfigProperties {

	@ConfigValue(watch = true)
	private String hostName;
	@ConfigValue(watch = true)
	private String hostValue;
	@ConfigValue(watch = true)
	private String keyName;
	@ConfigValue(watch = true)
	private String keyValue;
	@ConfigValue(watch = true)
	private String url;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHostValue() {
		return hostValue;
	}
	public void setHostValue(String hostValue) {
		this.hostValue = hostValue;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
