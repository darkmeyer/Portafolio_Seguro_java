/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguroescritorio;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DarKMeYeR
 */
public class SeguroEscritorio {
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguroEscritorioPU");
        EntityManager em = emf.createEntityManager();
        
        try
        {
            TypedQuery consulta = em.createNamedQuery("Ciudad.findByNombre", Ciudad.class);
            List<Ciudad> listaCiudad = consulta.setParameter("nombre", "Santiago").getResultList();
            for (Ciudad ciudad1 : listaCiudad) {              
                System.out.println("Ciudad: "+ciudad1.getNombre());
            }
            
            
            Empleado emp = new Empleado();
            emp.setIdEmpleado("1e");
            emp.setRut("17256155-1");
            emp.setPass("1234");
            emp.setNombres("Mauricio Hans");
            emp.setApellidos("Meyer Fernandez");
            emp.setCorreo("mau.meyer@alumnos.duoc.cl");
            emp.setFono("569-50265040");
            emp.setFechaNacimiento("05/01/1990");
            emp.setDireccion("Esquina blanca 893, Maipu");
            emp.setCiudadIdCiudad(listaCiudad.get(0));
            Cargo cargo = new Cargo();
            short idCargo = 1;
            cargo.setIdCargo(idCargo);
            emp.setCargoIdCargo(cargo);
            
            em.getTransaction().begin();
            em.persist(emp);
            
            Empleado emp2 = new Empleado();
            emp2.setIdEmpleado("2e");
            emp2.setRut("15670232-3");
            emp2.setPass("1234");
            emp2.setNombres("Mauricio Hans");
            emp2.setApellidos("Meyer Fernandez");
            emp2.setCorreo("mau.meyer@alumnos.duoc.cl");
            emp2.setFono("569-50265040");
            emp2.setFechaNacimiento("05/01/1990");
            emp2.setDireccion("Esquina blanca 893, Maipu");
            emp2.setCiudadIdCiudad(listaCiudad.get(0));
            idCargo = 3;
            cargo.setIdCargo(idCargo);
            emp2.setCargoIdCargo(cargo);
            
            em.persist(emp2);
            em.getTransaction().commit();        
            
            
        }
        catch(Exception e)
        {
            
        }
    }
    
}
