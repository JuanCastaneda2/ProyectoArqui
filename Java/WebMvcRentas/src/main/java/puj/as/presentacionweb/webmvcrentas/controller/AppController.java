package puj.as.presentacionweb.webmvcrentas.controller;

import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("app")
@Controller
public class AppController {

  
  @GET
  @View ("buscarLocalizacion.xhtml")
  public void buscarPorLocalizacion(){
      
  }
  
  @GET
  @Path("/listar/{localizacion}")
  @View ("listado.xhtml")
  public void listar(@PathParam("localizacion") String localizacion){
      
      
  }
}
