package com.youngprime.revenue.users.config;

import javax.enterprise.context.ApplicationScoped;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

@ApplicationScoped
@ConfigBundle("sms-config")
public class SmsConfigProperties {

	@ConfigValue(watch = true)
	private String urlSmsProvider;
	@ConfigValue(watch = true)
	private String usernameParamName;
	@ConfigValue(watch = true)
	private String passwordParamName;
	@ConfigValue(watch = true)
	private String messageParamName;
	@ConfigValue(watch = true)
	private String recipientsParamName;
	@ConfigValue(watch = true)
	private String senderParamName;
	@ConfigValue(watch = true)
	private String username;
	@ConfigValue(watch = true)
	private String password;
	
	public String getUsernameParamName() {
		return usernameParamName;
	}
	public void setUsernameParamName(String usernameParamName) {
		this.usernameParamName = usernameParamName;
	}
	public String getPasswordParamName() {
		return passwordParamName;
	}
	public void setPasswordParamName(String passwordParamName) {
		this.passwordParamName = passwordParamName;
	}
	public String getMessageParamName() {
		return messageParamName;
	}
	public void setMessageParamName(String messageParamName) {
		this.messageParamName = messageParamName;
	}
	public String getRecipientsParamName() {
		return recipientsParamName;
	}
	public void setRecipientsParamName(String recipientsParamName) {
		this.recipientsParamName = recipientsParamName;
	}
	public String getSenderParamName() {
		return senderParamName;
	}
	public void setSenderParamName(String senderParamName) {
		this.senderParamName = senderParamName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrlSmsProvider() {
		return urlSmsProvider;
	}
	public void setUrlSmsProvider(String urlSmsProvider) {
		this.urlSmsProvider = urlSmsProvider;
	}
	
}
