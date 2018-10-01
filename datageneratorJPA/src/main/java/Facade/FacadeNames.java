/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Names;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oliver
 */
public class FacadeNames {

    EntityManagerFactory emf;

    public FacadeNames(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Names> getAll() {
        EntityManager em = emf.createEntityManager();

        List<Names> names = null;
        
        try {
            em.getTransaction().begin();
            TypedQuery query = em.createQuery("SELECT new entity.Names(n.id, n.name, n.surname, n.gender) FROM Names n", Names.class);
            names = query.getResultList();
            em.getTransaction().commit();
            return names;
        } finally {
            em.clear();
        }
    }

}
