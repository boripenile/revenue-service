package com.youngprime.revenue.users;

import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@ApplicationPath("/v1")
@ApplicationScoped
@LoginConfig(authMethod = "MP-JWT")
@SwaggerDefinition(info = @Info(title = "Revenue System API - Users module", version = "v1.0.0"), 
	host = "localhost:8082", basePath = "/v1",  securityDefinition =
@SecurityDefinition(
		apiKeyAuthDefinitions = {
				@ApiKeyAuthDefinition(
						in = ApiKeyLocation.HEADER,
						key = "authorization",
						name = "Authorization",
						description = "Bearer Token"
				)
		}
))
public class UsersApplication extends Application{

}
