package puj.as.presentacionweb.webmvcrentas.proxys;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import puj.as.presentacionweb.webmvcrentas.dtos.ConfirmacionDTO;
import puj.as.sidecar.entities.Confirmacion;


public class ProxyWSIF {
    
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:51346/api/";

    public ProxyWSIF() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Solicitudes/");
    }
    
    public <T> ConfirmacionDTO solicitud(Object requestEntity) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Nueva");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), ConfirmacionDTO.class); 
   }
    
    
    

    
}