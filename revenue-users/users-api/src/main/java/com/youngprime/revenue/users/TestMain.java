package com.youngprime.revenue.users;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.youngprime.revenue.users.dtos.MPJWTToken;
import com.youngprime.revenue.users.dtos.UserDto;
import com.youngprime.revenue.users.mappers.UserMapper;
import com.youngprime.revenue.users.utils.TokenUtil;

public class TestMain {
	
	public static void main(String[] args) throws IOException {

        //PrivateKey key = readPrivateKey();
		MPJWTToken token = new MPJWTToken();
        token.setPreferredUsername("boripenipe");
        
        

        token.setSub("Murtadha");  // Sub is required for WildFly Swarm
        token.setUpn("Murtadha");

        token.addAdditionalClaims("custom-value", "Application specific value");

        token.setGroups(Arrays.asList("user", "users:view"));
        
        String jwt = null;
		try {
			System.out.println("Got here...");
			jwt = TokenUtil.generateTokenString(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
        //String jwt = "eyJraWQiOiJcL3ByaXZhdGVLZXkucGVtIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJhdWQiOiJ0YXJnZXRTZXJ2aWNlIiwic3ViIjpudWxsLCJ1cG4iOm51bGwsImlzcyI6Imh0dHBzOlwvXC9zZXJ2ZXIuZXhhbXBsZS5jb20iLCJncm91cHMiOlsicm9sZXM6dXBkYXRlIiwicm9sZXM6dmlldyIsInVzZXJzOmNyZWF0ZSIsInJvbGVzOmNyZWF0ZSIsInJvbGVzOmRlbGV0ZSJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJib3JpcGVuaWxlIiwiZXhwIjotNDY5MjQ2LCJpYXQiOi00OTgwNDYsImp0aSI6ImNlZmVlZjY0LTFkNWEtNGZlOS04MTJjLTcyNDA3MjBkY2FkNiJ9.UGpszQWSf0Z_eeRKOcWYdCCjNXzxmPQK8o29UQzJMHPAfWtmOYM76_bgUcZ6nFNo4c7zHLne4I0L1Qt9Ze5AQFZX3Ut_5qhuXn_n_jjm1kBbdc3UepaAbuve1BKpRkkFeUB4GoNmlyVjdXEQB2vqiFWINja4bSffkB_SXfuAcgSuTGyUSJr0LfxZkTpH4tEsIbYasXXY3KaUQ59n22Py1qK3dS4p5t_VARMmokxha0mht0QVPWOKThILw0RY-DkPzSxANUs3Y9lRFD31e2wOnaPJjiDJdlQCBlHhS1khti37poWNE__ThLwckDSjB5gRUwNsJmfkBqqhwouMwyU0Hw";
        //String jwt = generateJWT(key);
        System.out.println(jwt);

        // any method to send a REST request with an appropriate header will work of course.
        WebTarget target = ClientBuilder.newClient().target("http://localhost:8082/v1/users");
        Response response = target.request().header("Authorization", "Bearer " + jwt).buildGet().invoke();

        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
		
    }
}
