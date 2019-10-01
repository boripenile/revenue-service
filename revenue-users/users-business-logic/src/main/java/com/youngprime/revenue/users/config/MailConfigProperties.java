package com.youngprime.revenue.users.config;

import javax.enterprise.context.ApplicationScoped;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

@ApplicationScoped
@ConfigBundle("mail-config")
public class MailConfigProperties {

	@ConfigValue(watch = true)
	private String mailHost;
	@ConfigValue(watch = true)
	private int mailHostPort;
	@ConfigValue(watch = true)
	private String senderEmailId;
	@ConfigValue(watch = true)
	private String senderPassword;
	@ConfigValue(watch = true)
	private String mailFrom;
	@ConfigValue(watch = true)
	private String mailPersonel;
	@ConfigValue(watch = true)
	private String templateLocation;
	
	public String getMailHost() {
		return mailHost;
	}
	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}
	public int getMailHostPort() {
		return mailHostPort;
	}
	public void setMailHostPort(int mailHostPort) {
		this.mailHostPort = mailHostPort;
	}
	public String getSenderEmailId() {
		return senderEmailId;
	}
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	public String getSenderPassword() {
		return senderPassword;
	}
	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getMailPersonel() {
		return mailPersonel;
	}
	public void setMailPersonel(String mailPersonel) {
		this.mailPersonel = mailPersonel;
	}
	public String getTemplateLocation() {
		return templateLocation;
	}
	public void setTemplateLocation(String templateLocation) {
		this.templateLocation = templateLocation;
	}
	
}
