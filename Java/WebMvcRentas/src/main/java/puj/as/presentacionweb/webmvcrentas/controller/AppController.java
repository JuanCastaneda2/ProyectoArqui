package puj.as.presentacionweb.webmvcrentas.controller;

import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import puj.as.presentacionweb.webmvcrentas.dtos.ConfirmacionDTO;
import puj.as.presentacionweb.webmvcrentas.dtos.RegistroDTO;
import puj.as.presentacionweb.webmvcrentas.dtos.SolicitudDTO;
import puj.as.presentacionweb.webmvcrentas.proxys.ProxyWSIF;
import puj.as.presentacionweb.webmvcrentas.proxys.ProxyWSRentas;
import puj.as.presentacionweb.webmvcrentas.proxys.ProxyWSSI;
import puj.as.presentacionweb.webmvcrentas.repositorios.RegistroDataRepositorio;
import puj.as.presentacionweb.webmvcrentas.repositorios.RentasDataRepositorio;
import puj.as.presentacionweb.webmvcrentas.repositorios.SolicitudDataRepositorio;
import puj.as.sidecar.entities.Registro;
import puj.as.sidecar.entities.Renta;
import puj.as.sidecar.entities.Solicitud;

@Path("app")
@Controller
public class AppController {

    @Inject
    RentasDataRepositorio rentasDataRepositorio;
    
    @Inject
    SolicitudDataRepositorio solicitudDataRepositorio;
    
    @Inject
    RegistroDataRepositorio registroDataRepositorio;

    @GET
    @View("buscarLocalizacion.xhtml")
    public void buscarPorLocalizacion() {

    }
    
    @POST
    @Path("/if")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @View("institucionFinanciera.xhtml")
    public void solicitudIF(@Valid @BeanParam RegistroDTO registro) {
        Solicitud solicitud = new Solicitud();
        int valor = rentasDataRepositorio.getRenta().getPrecio() * registro.getDias();
        Integer id = (int) (Math.random() * (9999 - 0)) + 0;
        solicitud.setValor(valor);
        solicitud.setId(id);
        registro.setMonto(valor);
        solicitudDataRepositorio.setSolicitud(solicitud);
        registroDataRepositorio.setRegistro(registro);
        System.out.println(registro.getNombre());
    }

    @GET
    @Path("/list")
    @View("listado.xhtml")
    public void listar(@QueryParam("localizacion") String localizacion) {
        ProxyWSRentas proxy = new ProxyWSRentas();
        List<Renta> rentas = proxy.findByLocalizacion(localizacion);
        rentasDataRepositorio.setRentas(rentas);
    }
    
    
    @GET
    @Path("/finrenta/{placa}")
    @View("finRenta.xhtml")
    public void finalizarRenta(@PathParam("placa") String placa) {
        ProxyWSRentas proxy = new ProxyWSRentas();
        rentasDataRepositorio.setRenta(proxy.findByPlaca(placa));
        Registro registro = new Registro();
        registro.setPlaca(placa);
        Integer id = (int) (Math.random() * (9999 - 0)) + 0;
        registro.setRegistroId(id.toString());
        registro.setMonto(rentasDataRepositorio.getRenta().getPrecio());
        registroDataRepositorio.setRegistro(registro);
    }
    
    @POST
    @Path ("/pay")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @View("rentaFin.xhtml")
    public void pagar(@Valid @BeanParam SolicitudDTO solicitud){
        ProxyWSIF proxyIF = new ProxyWSIF();
        ProxyWSRentas proxy = new ProxyWSRentas();
        ConfirmacionDTO conf = proxyIF.solicitud(solicitud);
        Registro registro = registroDataRepositorio.getRegistro();
        if(conf.getAprobacion() != -1){
            ProxyWSSI proxySI = new ProxyWSSI();
            proxySI.AgregarRegistroAsinc(registro);
            proxy.rentar(registro.getPlaca());
        }
    }
}
