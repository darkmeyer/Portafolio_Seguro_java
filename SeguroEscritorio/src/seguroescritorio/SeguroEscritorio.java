/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguroescritorio;

import Datos.FafricaConexion;
import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author DarKMeYeR
 */
public class SeguroEscritorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PreparedStatement sentencia;
        ResultSet result;
    
        Connection cn = new FafricaConexion().Conectar();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguroEscritorioPU");
        EntityManager em = emf.createEntityManager();
        
        try
        {
            Region region = new Region();
            TypedQuery consulta = em.createNamedQuery("Region.findAll", Region.class);
            List<Region> listaRegion = consulta.getResultList();
            for (Region region1 : listaRegion) {              
                System.out.println("Region: "+region1.getNombre());
            }
        }
        catch(Exception e)
        {
            
        }
    }
    
}
