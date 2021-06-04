/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.presentacionweb.webmvcrentas.proxys;

import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import puj.as.sidecar.entities.Renta;

/**
 * Jersey REST client generated for REST resource:WSManagerRentas
 * [managerrentas]<br>
 * USAGE:
 * <pre>
 *        ProxyWSRentas client = new ProxyWSRentas();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class ProxyWSRentas {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WSRentas/resources";

    public ProxyWSRentas() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("managerrentas");
    }

    public Response rentar(String placa) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("rentar/{0}", new Object[]{placa}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Response.class);
    }

    public <T> List<Renta> findByLocalizacion(String barrio) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("localizacion/{0}", new Object[]{barrio}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Renta>>() {
        });
    }

    public <T> Renta findByPlaca(String placa) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{placa}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Renta.class);
    }

    public Response addRenta(Object requestEntity) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public void close() {
        client.close();
    }
    
}
