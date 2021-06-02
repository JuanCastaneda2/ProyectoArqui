/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.negocio.sistemasi.wsregistros;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import puj.as.sidecar.entities.Registro;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("gestionRegistro")
public class WSManagerRegistros {
    
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory jmsFactory;
    @Resource(lookup = "jms/registros")
    private Queue jmsQueue;
    
    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }

    @POST
    public Response AgregarRegistroAsinc(Registro newRegistro) {
        try (Connection connection = jmsFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer producer = session.createProducer(jmsQueue)) {
            ObjectMessage message = session.createObjectMessage();
            message.setObject(newRegistro);
            producer.send(message);
            return Response.ok("Creacion de Registro en Proceso").build();
        } catch (JMSException e) {
            System.out.println("error JMS:" + e.toString());
        } catch (Exception ex) {
            System.out.println("error Ex:" + ex.toString());
        }
        return Response.ok("Error en Creacion del Registro").build();
    }


}
