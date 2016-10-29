package com.ge.predix.solsvc.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * 
 * @author predix -
 */
@Consumes(
{
        "application/json", "application/xml"
})
@Produces(
{
        "application/json", "application/xml"
})
public interface SeedDataAPI
{
	/**
	 * @return -
	 */
	@GET
	@Path("seed/ping")
	public Response greetings();


	/**
	 * 
	 * @return List of tags
	 */
	@GET
	@Path("seed/tags")
	public Response getTags();
	
	/**
	 * @param id
	 *            -
	 * @param authorization
	 *            -
	 * @param starttime
	 *            -
	 * @param tagLimit -
	 * @param tagorder -
	 * @return -
	 */
	@GET
	@Path("/yearly_data/sensor_id/{id}")
	public Response getYearlyWindDataPoints(@PathParam("id") String id,
			@HeaderParam(value = "Authorization") String authorization,
			@DefaultValue("1y-ago") @QueryParam("starttime") String starttime,
			@DefaultValue("25") @QueryParam("taglimit") String tagLimit,@DefaultValue("desc") @QueryParam("order") String tagorder);
}

