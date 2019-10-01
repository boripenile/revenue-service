package com.youngprime.revenue.users.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.youngprime.revenue.users.config.ImageConfigProperties;
import com.youngprime.revenue.users.config.SmsConfigProperties;

@ApplicationScoped
public class SmsService {
	
	@Inject
	private SmsConfigProperties smsConfig;
	
	public void sendSMS(Sms simpleSms) {
		try {
//			@SuppressWarnings("resource")
//			DefaultHttpClient client = new DefaultHttpClient();
	        for (String number : simpleSms.getToNumbers()) {
	            String strUri = smsConfig.getUrlSmsProvider() + "?" + 
	            		smsConfig.getSenderParamName() + "=" + encodeParam(smsConfig.getUsername()) 
	                    + "&" + smsConfig.getPasswordParamName() + "=" + smsConfig.getPassword() + 
	                    "&" + smsConfig.getMessageParamName() + "=" + encodeParam(simpleSms.getMessage()) + "&" + 
	                    smsConfig.getRecipientsParamName() + "="
	                    + encodeParam(number) + "&" + smsConfig.getSenderParamName() + "=" + encodeParam(simpleSms.getSender()) + "&flash=1";
	            System.out.println("Connecting..." + strUri);
	            
//	            Get getSms = Http.get(strUri, 30000, 3000)
//	            			.header("accept", "text/html");
//	            
//	            System.out.println(getSms.responseCode());
//	            System.out.println(getSms.text("UTF-8"));
//	            if (getSms.responseCode() == 200) {
//	            	System.out.println(getSms.text("UTF-8"));
//	            }
//	            URI uri = new URI(strUri);
//	            HttpGet get = new HttpGet(uri);
//	            
//	            get.addHeader("accept", "text/html");
//
//	            HttpResponse response = client.execute(get);
//	            if (response.getStatusLine().getStatusCode() != 200) {
//	                throw new RuntimeException("Operation failed: " + response.getStatusLine().getStatusCode());
//	            }
//
//	            System.out.println("Content-Type: " + response.getEntity().getContentType().getValue());
//
//	            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//	            String line = reader.readLine();
//	            while (line != null) {
//	                System.out.println(line);
//	                line = reader.readLine();
//	            }
	        }
//	        client.getConnectionManager().shutdown();
		} catch (Exception e) {
			// TODO: handle exception
		}  
    }
    
    private static String encodeParam(String paramValue) throws UnsupportedEncodingException{
        return URLEncoder.encode(paramValue, "UTF-8");
    }
    
    public static void main(String[] args) {
    	// System.out.println(properties.get("username"));
    }
}
