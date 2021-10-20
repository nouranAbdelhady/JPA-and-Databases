package Demo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hello")
public class Controller {
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public Response test() {
		return Response.ok("Test function").build();
	}
}
