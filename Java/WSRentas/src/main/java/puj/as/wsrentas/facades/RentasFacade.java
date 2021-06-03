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
import puj.as.sidecar.entities.Renta;

/**
 *
 * @author admin
 */
@Stateless
public class RentasFacade extends AbstractFacade<Renta> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentasFacade() {
        super(Renta.class);
    }
    
    public List<Renta> findByLocalizacion(String barrio){
        TypedQuery<Renta> query = 
                em.createQuery(
                        "select r from Renta r where r.localizacion=:barrio AND NOT r.rentado"
                        , Renta.class
                );
        query.setParameter("barrio", barrio);
        return query.getResultList();
    }
}
