/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.wsrentas;

import java.net.URI;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import puj.as.sidecar.entities.Rentas;
import puj.as.wsrentas.facades.RentasFacade;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("managerrentas")
@RequestScoped
public class WSManagerRentas {

    @Inject
    RentasFacade rentasFacade;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSManagerRentas
     */
    public WSManagerRentas() {
    }

    /**
     * Retrieves representation of an instance of
     * puj.as.wsrentas.WSManagerRentas
     *
     * @return an instance of puj.as.sidecar.entities.Rentas
     */
    @GET
    @Path("/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByPlaca(@PathParam("placa") String placa) {
        Rentas renta = rentasFacade.find(placa);
        if (renta != null) {
            return Response
                    .ok(renta)
                    .build();
        }
        return Response.status(
                Response.Status.NOT_FOUND).build();

    }

    /**
     * PUT method for updating or creating an instance of WSManagerRentas
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRenta(Rentas renta) {
        rentasFacade.create(renta);
        URI createdURI = context.getBaseUriBuilder()
                .path(
                        renta.getPlaca()
                ).build();
        return Response.created(createdURI).build();
    }
    
    @GET
    @Path ("/localizacion/{barrio}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByLocalizacion(@PathParam("barrio") String barrio) {
        final List<Rentas> rentas = rentasFacade.findByLocalizacion(barrio);
        if (rentas.size() > 0) {
            return Response.ok(rentas).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @PUT
    @Path ("/rentar/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response rentar(@PathParam("placa") String placa) {
        Rentas renta = rentasFacade.find(placa);
        if (renta != null) {
            renta.setRentado(Boolean.TRUE);
            rentasFacade.edit(renta);
            return Response
                    .ok(renta)
                    .build();
        }
        return Response.status(
                Response.Status.NOT_FOUND).build();

    }
}
