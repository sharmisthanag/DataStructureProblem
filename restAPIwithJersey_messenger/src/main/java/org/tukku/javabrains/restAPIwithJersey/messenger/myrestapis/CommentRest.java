package org.tukku.javabrains.restAPIwithJersey.messenger.myrestapis;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tukku.javabrains.restAPIwithJersey.messenger.beans.Comment;

@Path("/")
public class CommentRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getComments(){
		return getCommentList();	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentId}")
	public List<Comment> getCommentsForId(@PathParam("commentId") Long commentId,@PathParam("empId") Long empId){
		System.out.println("commentId="+commentId+" employeeId="+empId);
		return getCommentList().subList(0, 2);	
	}
	private List<Comment> getCommentList() {
		List<Comment> l=new ArrayList<Comment>();
		l.add(new Comment((long)1,"hello"));
		l.add(new Comment((long)1,"hi"));
		l.add(new Comment((long)2,"gelo re gello"));
		l.add(new Comment((long)3,"happy rakhi"));
		l.add(new Comment((long)3,"tukku valo"));
		return l;
	}

}
