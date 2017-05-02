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
            
            consulta = em.createNamedQuery("Empleado.findByCargo", Empleado.class);
            List<Empleado> listaEmp = consulta.setParameter("cargo", "liquidador").getResultList();
            for (Empleado empleado : listaEmp) {
                System.out.println("Empleado: "+empleado.getRut());
            }
            
            String pass = "1234";
            Administrador admin = new Administrador();
            Empleado emp = new Empleado();
            emp.setAdministrador(admin);
            emp.setIdEmpleado("1e");
            emp.setRut("17256155-1");
            emp.setPass(BCrypt.hashpw(pass, BCrypt.gensalt()));
            emp.setNombres("Mauricio Hans");
            emp.setApellidos("Meyer Fernandez");
            emp.setCorreo("mau.meyer@alumnos.duoc.cl");
            emp.setFono("569-50265040");
            Date sd = new Date("05/01/1990");
            emp.setFechaNacimiento(sd);
            emp.setDireccion("Esquina blanca 893, Maipu");
            emp.setCiudadIdCiudad(listaCiudad.get(0));
            emp.setCargo("Administrador");
            emp.getAdministrador().setIdAdministrador("1a");
            emp.getAdministrador().setEmpleadoIdEmpleado(emp);
            
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        
            consulta = em.createNamedQuery("Administrador.findAll", Empleado.class);
            List<Administrador> listaAdm = consulta.getResultList();
            if(listaAdm != null){
                System.out.println(listaAdm.get(0).getEmpleadoIdEmpleado().getRut());
            }
            
        }
        catch(Exception e)
        {
            
        }
    }
    
}
