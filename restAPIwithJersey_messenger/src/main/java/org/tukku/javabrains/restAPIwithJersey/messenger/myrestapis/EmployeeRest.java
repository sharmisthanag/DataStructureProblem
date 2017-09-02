package org.tukku.javabrains.restAPIwithJersey.messenger.myrestapis;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.tukku.javabrains.restAPIwithJersey.messenger.beans.Employee;
import org.tukku.javabrains.restAPIwithJersey.messenger.beans.EmployeeBean;
import org.tukku.javabrains.restAPIwithJersey.messenger.services.EmployeeServices;

@Path("employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRest {
	
	@GET
	@Path("inxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getAllEmployeeDetails(){		
		return new EmployeeServices().getAllEmployees();		
	}	
	
	@GET
	public List<Employee> getAllEmployeeDetailsinJSON(){		
		return new EmployeeServices().getAllEmployees();	
	}
	
	@GET
	@Path("/{empId}")
	public Employee getEmployeeDetailsById(@PathParam("empId") Long empId,@Context UriInfo uriInfo){
		Employee getEmp =  new EmployeeServices().getEmployeeWithId(empId);

		return getEmp;		
	}
	
	@POST	
	public Response addEmployee(Employee emp,@Context UriInfo uriInfo){
		Employee createdEmp = new EmployeeServices().addEmployee(emp);
		createdEmp.addLink(uriInfo.getBaseUriBuilder().path(EmployeeRest.class).path(createdEmp.getEmpId().toString()).build().toString(),"self");
		return Response.created(uriInfo.getAbsolutePathBuilder().path(createdEmp.getEmpId().toString()).build())
				.entity(createdEmp)
				.build();
		 
	
/*		return Response.status(Status.CREATED)
				.entity(new EmployeeServices().addEmployee(emp))
				.build();*/		 
	}
	
	@PUT
	@Path("/{empId}")
	public Response updateEmployee(@PathParam("empId")Long empId,Employee emp,@Context UriInfo uriInfo){
		emp.setEmpId(empId);
		Employee updatedEmp = new EmployeeServices().updateEmployee(emp); 
		System.out.println(updatedEmp);
		return Response.status(Status.OK)
				.location(uriInfo.getAbsolutePath())
				.entity(updatedEmp)
				.build();
	}
	
	@DELETE
	@Path("/{empId}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response delEmployee(@PathParam("empId")Long empId,@Context HttpHeaders headers ){
		return Response.status(Status.OK)
				.type(headers.getMediaType())
				.entity(new EmployeeServices().deleteEmployee(empId))
				.build();		 
	}

	
	@GET
	@Path("/queryparam")
	public List<Employee> getEmployeeDetailsById(@QueryParam("year") Integer year,
												 @QueryParam("start") Integer start,
												 @QueryParam("size") Integer size){
		System.out.println("year=>"+year);
		System.out.println("start=>"+start);
		System.out.println("size=>"+size);
		if(year!=null){
			return new EmployeeServices().getEmployeeByYear(year);
		}
		else if(start!=null && size!=null){
			return new EmployeeServices().getEmployeeByStartPOSAndSize(start,size);
		}
		return new ArrayList<Employee>();
		
	}
	@GET
	@Path("/userbeanparam")
	public List<Employee> getEmployeeDetailsByBeanParam(@BeanParam EmployeeBean employeeBean){
		System.out.println("year=>"+employeeBean.getYear());
		System.out.println("start=>"+employeeBean.getStart());
		System.out.println("size=>"+employeeBean.getSize());
		if(employeeBean.getYear()!=null){
			return new EmployeeServices().getEmployeeByYear(employeeBean.getYear());
		}
		else if(employeeBean.getStart()!=null && employeeBean.getSize()!=null){
			return new EmployeeServices().getEmployeeByStartPOSAndSize(employeeBean.getStart(),employeeBean.getSize());
		}
		return new ArrayList<Employee>();
		
	}
	
	@Path("/{empId}/comments")
	public CommentRest rediectToCommentRest(){
		return new CommentRest();
		
	}
}
