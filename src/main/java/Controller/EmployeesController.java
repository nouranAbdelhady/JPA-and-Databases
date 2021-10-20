package Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Queries.BonusQuery;
import Queries.Query1;

@Path("/employees")
public class EmployeesController {
	//access using "http://localhost:8080/api/employees"
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllEmployees() {
        //return Response.ok("Get all employees:").build();
        return Response.ok(Query1.getEmployees()).build();
    }
	
	//access using "http://localhost:8080/api/employees/{targetedRole}"
	@GET
	@Path("/{targetedRole}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getEmployeesInProject(@PathParam("targetedRole") String targetedRole) {	        
		//return Response.ok("Getting employees with Role: "+ projectName).build();
		return Response.ok(BonusQuery.getEmployeesWithoutProject(targetedRole)).build();
	}
}
