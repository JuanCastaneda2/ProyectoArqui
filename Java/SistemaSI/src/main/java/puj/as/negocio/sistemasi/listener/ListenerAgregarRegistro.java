/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.negocio.sistemasi.listener;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import puj.as.negocio.sistemasi.facades.FacadeAgregarRegistros;
import puj.as.sidecar.entities.Registro;

/**
 *
 * @author admin
 */

@MessageDriven(name = "addRegistromdb", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue= "jms/registros"),
    @ActivationConfigProperty(propertyName = "destinationType", 
            propertyValue= "javax.jms.Queue") })

public class ListenerAgregarRegistro implements MessageListener {

    @Inject
    FacadeAgregarRegistros facadeAgregarRegistros;
    
    @Override
    public void onMessage(Message msg) {
        
        try {
            ObjectMessage objectRegistro = (ObjectMessage)msg;
            Registro registro = (Registro) objectRegistro.getObject();
            facadeAgregarRegistros.AgregarRegistro(registro);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        
    }
    
}
