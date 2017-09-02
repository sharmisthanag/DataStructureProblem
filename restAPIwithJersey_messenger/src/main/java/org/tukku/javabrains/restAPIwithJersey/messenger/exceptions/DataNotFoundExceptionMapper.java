package org.tukku.javabrains.restAPIwithJersey.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.tukku.javabrains.restAPIwithJersey.messenger.beans.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage e=new ErrorMessage(404,exception.getMessage());
		return Response.status(Status.NOT_FOUND).entity(e).build();
	}
	

}
