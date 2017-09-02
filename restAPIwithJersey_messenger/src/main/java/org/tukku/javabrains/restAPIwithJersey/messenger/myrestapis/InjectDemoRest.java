package org.tukku.javabrains.restAPIwithJersey.messenger.myrestapis;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoRest {
	
	@GET
	public String getParamUsingAnnotaion(@MatrixParam("param") String mvalue,
										@HeaderParam("param") String hvalue,
										@CookieParam("name") String cvalue){
		return "Matrix: param="+mvalue+"\n Header: param="+hvalue+" Cookie:name="+cvalue;
	}

	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo){
		System.out.println(uriInfo.getAbsolutePath());
		return uriInfo.getQueryParameters().toString();
	}
}
