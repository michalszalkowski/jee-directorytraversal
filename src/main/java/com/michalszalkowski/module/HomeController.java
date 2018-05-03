package com.michalszalkowski.module;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("/")
public class HomeController {

	private static final String TEST_DIR = "/home/szalek/Workspace/Playground/jee-directorytraversal";

	@GET
	@Path("/test1/{path}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response group1(@PathParam("path") String path) {

		String fileName = String.format("%s", path);

		String filePath = TEST_DIR + "/report/" + fileName;

		Response.ResponseBuilder response = Response.ok(
				new File(filePath)
		);

		return response.build();
	}

	@GET
	@Path("/test2/{path}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response group2(@PathParam("path") String path) {

		String fileName = String.format("%s.txt", path);

		String filePath = TEST_DIR + "/report/" + fileName;

		Response.ResponseBuilder response = Response.ok(
				new File(filePath)
		);

		return response.build();
	}

	@GET
	@Path("/test3/{path}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response group3(@PathParam("path") String path) {

		String fileName = String.format("report_file_%s.txt", path);

		String filePath = TEST_DIR + "/report/" + fileName;

		Response.ResponseBuilder response = Response.ok(
				new File(filePath)
		);

		return response.build();
	}

}
