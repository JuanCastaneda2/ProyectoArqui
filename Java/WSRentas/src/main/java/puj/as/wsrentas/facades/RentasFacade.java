/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.wsrentas.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import puj.as.sidecar.entities.Rentas;

/**
 *
 * @author admin
 */
@Stateless
public class RentasFacade extends AbstractFacade<Rentas> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentasFacade() {
        super(Rentas.class);
    }
    
    public List<Rentas> findByLocalizacion(String barrio){
        TypedQuery<Rentas> query = 
                em.createQuery(
                        "select r from Rentas r where r.localizacion=:barrio AND NOT r.rentado"
                        , Rentas.class
                );
        query.setParameter("barrio", barrio);
        return query.getResultList();
    }
}
