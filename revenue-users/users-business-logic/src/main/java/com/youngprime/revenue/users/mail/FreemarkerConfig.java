package com.youngprime.revenue.users.mail;

import java.io.File;
import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.youngprime.revenue.users.config.MailConfigProperties;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

@ApplicationScoped
public class FreemarkerConfig {
	
	@Inject
	private MailConfigProperties mailConfig;
	
	private Configuration configuration;
	
	public FreemarkerConfig() {
		configuration = new Configuration(Configuration.VERSION_2_3_23);
        try {
			String templateLocation = mailConfig.getTemplateLocation();
        	configuration.setDirectoryForTemplateLoading( new File(templateLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);       
	}
	
	public Configuration getConfiguration() {
		return this.configuration;
	}

}
