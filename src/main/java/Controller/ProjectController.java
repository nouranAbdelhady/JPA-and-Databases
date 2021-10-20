package Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Queries.Query3;

@Path("/project")
public class ProjectController {
		//access using "http://localhost:8080/api/project/{projectName}"
		@GET
		@Path("/{projectName}")
	    @Produces(MediaType.TEXT_PLAIN)
	    public Response getEmployeesInProject(@PathParam("projectName") String projectName) {
	        //return Response.ok("Getting employees in Project: "+ projectName).build();
	        return Response.ok(Query3.getEmployeesInProject(projectName)).build();
	    }
	
}
