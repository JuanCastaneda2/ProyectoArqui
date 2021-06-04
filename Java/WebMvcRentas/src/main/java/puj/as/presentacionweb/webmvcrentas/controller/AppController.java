package puj.as.presentacionweb.webmvcrentas.controller;

import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import puj.as.presentacionweb.webmvcrentas.dtos.SolicitudDTO;
import puj.as.presentacionweb.webmvcrentas.proxys.ProxyWSRentas;
import puj.as.presentacionweb.webmvcrentas.repositorios.RentasDataRepositorio;
import puj.as.presentacionweb.webmvcrentas.repositorios.SolicitudDataRepositorio;
import puj.as.sidecar.entities.Renta;

@Path("app")
@Controller
public class AppController {

    @Inject
    RentasDataRepositorio rentasDataRepositorio;
    
    @Inject
    SolicitudDataRepositorio solicitudDataRepositorio;

    @GET
    @View("buscarLocalizacion.xhtml")
    public void buscarPorLocalizacion() {

    }
    
    @GET
    @Path("/if/{placa}")
    @View("institucionFinanciera.xhtml")
    public void solicitudIF(@PathParam("placa") String placa) {
        ProxyWSRentas proxy = new ProxyWSRentas();
        rentasDataRepositorio.setRenta(proxy.findByPlaca(placa));
    }

    @GET
    @Path("/list")
    @View("listado.xhtml")
    public void listar(@QueryParam("localizacion") String localizacion) {
        ProxyWSRentas proxy = new ProxyWSRentas();
        List<Renta> rentas = proxy.findByLocalizacion(localizacion);
        rentasDataRepositorio.setRentas(rentas);
    }
    
    @POST
    @Path ("/pay")
    @View("listado.xhtml")
    public void pagar(){
        
    }
}
