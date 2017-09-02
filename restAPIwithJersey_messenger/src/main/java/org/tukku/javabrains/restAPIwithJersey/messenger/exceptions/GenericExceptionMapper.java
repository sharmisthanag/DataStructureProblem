package org.tukku.javabrains.restAPIwithJersey.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.tukku.javabrains.restAPIwithJersey.messenger.beans.ErrorMessage;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception exception) {
		ErrorMessage e=new ErrorMessage(500,exception.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(e)
				.build();
	}
	

}
