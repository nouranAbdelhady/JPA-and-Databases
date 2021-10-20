package Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Queries.BonusQuery;
import Queries.Query1;
import Queries.Query2;

@Path("/employee")
public class EmployeesController {
	//access using "http://localhost:8080/api/employee/all"
	@GET
	@Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllEmployees() {
        //return Response.ok("Get all employees:").build();
        return Response.ok(Query1.getEmployees()).build();
    }
	
	//access using "http://localhost:8080/api/employee/{targetedRole}"
	@GET
	@Path("/{targetedRole}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getEmployeesInProject(@PathParam("targetedRole") String targetedRole) {	        
		//return Response.ok("Getting employees with Role: "+ projectName).build();
		return Response.ok(BonusQuery.getEmployeesWithoutProject(targetedRole)).build();
	}
	
	//access using "http://localhost:8080/api/employee/add-employee-to-project/{employeeId}/{projectId}"
	@GET
    @Path("/add-employee-to-project/{employeeId}/{projectId}")
    public Response addEmployeeToProject(@PathParam("employeeId") Integer employeeId, @PathParam("projectId") Integer projectId){
        return Response.ok(Query2.addEmployeeToProject(employeeId, projectId)).build();
    }
	
}
