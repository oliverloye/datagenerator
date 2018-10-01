/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityRunner;

import Facade.FacadeNames;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpapu");
        //Persistence.generateSchema("jpapu", null);
        
        FacadeNames fn = new FacadeNames(emf);
        
        System.out.println(fn.getAll());
        
    }
    
}
