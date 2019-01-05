package com.dekses.jersey.docker.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("clientresource")
public class MyResource {

    private WebTarget target;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
	System.out.println("Client");

	Client c = ClientBuilder.newClient();
	System.out.println("Client2");
        String url = System.getenv ("JERSEY_URL");
	System.out.println("URL=" + url);
//	String url = "http://hellojersey/myapp/";
//	System.out.println("URL static =" + url);
//	String url = "http://localhost:8080/myapp/";

	System.out.println("Client3");
        target = c.target(url);
	System.out.println("Client4");
	String responseMsg = "";
        try {
System.out.println("Client5");
        target = target.path("myresource");
System.out.println("Client6");
	System.out.println("URI=" + target.getUri());
	responseMsg = target.request().get(String.class);
	} catch ( Exception e ) {
            e.printStackTrace();
	}
	System.out.println ("Client ready");    
        return responseMsg;

	//return "Got it!";  
  }
}
