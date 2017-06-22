/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Admin;

import Datos.FafricaConexion;
import Entidades.Ciudad;
import Entidades.Empleado;
import Entidades.Region;
import Entidades.Taller;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author DarKMeYeR
 */
public class TallerMantenedor extends javax.swing.JFrame {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguroEscritorioPU");
    EntityManager em = emf.createEntityManager();
    String mensaje = "";
    public TallerMantenedor() {
        initComponents();
        llenarComboBoxRegiones();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtIdTaller = new javax.swing.JTextField();
        btnBuscarTaller = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtFono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaMensaje = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbRegion = new javax.swing.JComboBox<>();
        cbCiudad = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblMensajeBuscar = new javax.swing.JLabel();
        btnBuscarTallerRut = new javax.swing.JButton();
        lblMensajeBuscarRut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenedor Taller");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Mantenedor Taller");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("ID");

        txtIdTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTallerActionPerformed(evt);
            }
        });
        txtIdTaller.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdTallerKeyTyped(evt);
            }
        });

        btnBuscarTaller.setText("Buscar");
        btnBuscarTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTallerActionPerformed(evt);
            }
        });

        jLabel10.setText("Fono");

        jLabel11.setText("Direccion");

        jLabel12.setText("Region");

        jLabel13.setText("Rut Encargado");

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        txaMensaje.setColumns(20);
        txaMensaje.setRows(5);
        jScrollPane2.setViewportView(txaMensaje);

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnActualizar)
                    .addComponent(btnBorrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel14.setText("Ciudad");

        cbRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRegionActionPerformed(evt);
            }
        });

        jLabel15.setText("Nombre");

        btnBuscarTallerRut.setText("Buscar");
        btnBuscarTallerRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTallerRutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtIdTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarTaller)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMensajeBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarTallerRut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMensajeBuscarRut, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFono)
                                    .addComponent(txtDireccion)
                                    .addComponent(cbRegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(140, 140, 140)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtIdTaller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarTaller))
                    .addComponent(lblMensajeBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addComponent(btnBuscarTallerRut, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(lblMensajeBuscarRut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(52, 52, 52)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTallerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTallerActionPerformed

    private void btnBuscarTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTallerActionPerformed
        try
        {
            if(!txtIdTaller.getText().isEmpty())
            {
                List<Taller> listTaller = buscarTaller(txtIdTaller.getText()+"t");
                if(listTaller != null)
                {
                    txtNombre.setText(listTaller.get(0).getNombre());
                    txtFono.setText(listTaller.get(0).getFono());
                    txtDireccion.setText(listTaller.get(0).getDireccion());
                    txtRut.setText(listTaller.get(0).getEmpleadoIdEmpleado().getRut());                  
                    cbRegion.setSelectedItem(listTaller.get(0).getCiudadIdCiudad().getRegionIdRegion().getIdRegion()+ " " + listTaller.get(0).getCiudadIdCiudad().getRegionIdRegion().getNombre());
                    cbCiudad.setSelectedItem(listTaller.get(0).getCiudadIdCiudad().getIdCiudad()+" "+listTaller.get(0).getCiudadIdCiudad().getNombre()); 
                    
                    lblMensajeBuscar.setText("ID encontrada");
                }
                else
                {
                    lblMensajeBuscar.setText("ID no encontrada");
                }
            }
            else
            {
                lblMensajeBuscar.setText("Ingrese ID");
            }
        }
        catch(Exception e)
        {
            lblMensajeBuscar.setText("Error");
        }
    }//GEN-LAST:event_btnBuscarTallerActionPerformed

    private void cbRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRegionActionPerformed
        String item = cbRegion.getSelectedItem().toString();
        String[] itemSplit = item.split("\\s+");
        int id = Integer.parseInt(itemSplit[0].toString());
        llenarComboBoxCiudades(id);
    }//GEN-LAST:event_cbRegionActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try
        {
            if(camposVacios())
            {
                String item = cbCiudad.getSelectedItem().toString();
                String[] itemSplit = item.split("\\s+");
                int idCiudad = Integer.parseInt(itemSplit[0]);
                
                String rut = txtRut.getText();
                rut = rut.replace(".","");
                rut = rut.replace("-","");
                List<Empleado> listEmp = buscarEmpleadoRut(rut);
                if(listEmp != null)
                {
                    if(listEmp.get(0).getCargoIdCargo().getNombre().equalsIgnoreCase("Admin Taller"))
                    {
                        
                        Connection cn = new FafricaConexion().Conectar();
                        try {
                            
                            Taller taller = new Taller();
                            taller.setNombre(txtNombre.getText());
                            taller.setFono(txtFono.getText());
                            taller.setDireccion(txtDireccion.getText());

                            CallableStatement cs = cn.prepareCall("{call ? := F_INSERT_TALLER(?,?,?,?,?)}");
                            cs.registerOutParameter(1, Types.VARCHAR);

                            cs.setString(2, taller.getNombre());
                            cs.setString(3, taller.getFono());
                            cs.setString(4, taller.getDireccion());
                            cs.setInt(5, idCiudad);
                            cs.setString(6, listEmp.get(0).getIdEmpleado());
                            cs.executeUpdate();
                            String mensaje2 = cs.getString(1);
                            mensaje += mensaje2+" \n";
                            txaMensaje.setText(mensaje);
                        } catch (Exception e) {
                            mensaje += e.getMessage()+"\n";
                            txaMensaje.setText(mensaje);
                        }
                    }
                    else
                    {
                        mensaje += "Este Rut no pertenece a un Encargado Taller \n";
                        txaMensaje.setText(mensaje); 
                    }
                }
                else
                {
                    mensaje += "Encargado no Registrado \n";
                    txaMensaje.setText(mensaje); 
                }
                
                
            }
            else
            {
                mensaje += "Llene todos los campos \n";
                txaMensaje.setText(mensaje);
            }
        }
        catch(Exception e)
        {
            mensaje += "Error \n";
            txaMensaje.setText(mensaje);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try
        {
            if(camposVacios())
            {
                String item = cbCiudad.getSelectedItem().toString();
                String[] itemSplit = item.split("\\s+");
                short idCiudad = Short.parseShort(itemSplit[0]);
                String id = txtIdTaller.getText();
                
                String rut = txtRut.getText();
                rut = rut.replace(".","");
                rut = rut.replace("-","");
                if(buscarTaller(id+"t") != null)
                {
                    List<Empleado> listEmp = buscarEmpleadoRut(rut);
                    if(listEmp != null)
                    {
                        if(listEmp.get(0).getCargoIdCargo().getNombre().equalsIgnoreCase("Admin Taller"))
                        {
                            try {
                                Ciudad ciudad = new Ciudad();
                                ciudad.setIdCiudad(idCiudad);
                                Taller taller = new Taller();
                                taller.setIdTaller(txtIdTaller.getText()+"t");
                                taller.setNombre(txtNombre.getText());
                                taller.setFono(txtFono.getText());
                                taller.setDireccion(txtDireccion.getText());
                                taller.setCiudadIdCiudad(ciudad);
                                taller.setEmpleadoIdEmpleado(listEmp.get(0));

                                em.getTransaction().begin();
                                em.merge(taller);
                                em.getTransaction().commit();

                                mensaje += "Taller Actualizado \n";
                                txaMensaje.setText(mensaje);
                            }
                            catch(RollbackException s)
                            {
                                mensaje += "No puede actualizar a un rut en uso\n";
                                txaMensaje.setText(mensaje);
                            }
                            catch(Exception e)
                            {
                                mensaje += e.getMessage()+"\n";
                                txaMensaje.setText(mensaje);
                            }
                        }
                        else
                        {
                            mensaje += "Este Rut no pertenece a un Encargado Taller \n";
                            txaMensaje.setText(mensaje); 
                        }
                    }
                    else
                    {
                        mensaje += "Encargado no Registrado \n";
                        txaMensaje.setText(mensaje); 
                    }
                }
                else
                {
                    mensaje += "ID Taller no existe \n";
                    txaMensaje.setText(mensaje); 
                }
                
            }
            else
            {
                mensaje += "Llene todos los campos \n";
                txaMensaje.setText(mensaje);
            }
        }
        catch(Exception e)
        {
            mensaje += "Error \n";
            txaMensaje.setText(mensaje);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try
        {
            if(!txtIdTaller.getText().isEmpty())
            {    
                String id = txtIdTaller.getText();
                List<Taller> listTaller = buscarTaller(id+"t");
                if(listTaller != null)
                {
                    em.getTransaction().begin();
                    em.remove(listTaller.get(0));
                    em.getTransaction().commit();
                    mensaje += "Taller Eliminado \n";
                    txaMensaje.setText(mensaje);
                }
                else
                {
                    mensaje += "Taller No existe \n";
                    txaMensaje.setText(mensaje);
                }
            }
            else
            {
                mensaje += "Ingrese la ID \n";
                txaMensaje.setText(mensaje);
            }
        }
        catch(Exception e)
        {
            mensaje += "Error \n";
            txaMensaje.setText(mensaje);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        mensaje = "";
        txaMensaje.setText(mensaje);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarTallerRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTallerRutActionPerformed
        try
        {
            if(!txtRut.getText().isEmpty())
            {   
                String rut = txtRut.getText();
                rut = rut.replace(".","");
                rut = rut.replace("-","");
                String id = buscarTallerRut(rut);
                List<Taller> listTaller = !(id.equals("-1")) ? buscarTaller(id) : null;
                if(listTaller != null)
                {
                    txtNombre.setText(listTaller.get(0).getNombre());
                    txtFono.setText(listTaller.get(0).getFono());
                    txtDireccion.setText(listTaller.get(0).getDireccion());
                    txtIdTaller.setText(listTaller.get(0).getIdTaller().substring(0 , listTaller.get(0).getIdTaller().length()-1));
                    cbRegion.setSelectedItem(listTaller.get(0).getCiudadIdCiudad().getRegionIdRegion().getIdRegion()+ " " + listTaller.get(0).getCiudadIdCiudad().getRegionIdRegion().getNombre());
                    cbCiudad.setSelectedItem(listTaller.get(0).getCiudadIdCiudad().getIdCiudad()+" "+listTaller.get(0).getCiudadIdCiudad().getNombre()); 
                    
                    lblMensajeBuscarRut.setText("Rut encontrada");
                }
                else
                {
                    lblMensajeBuscarRut.setText("Rut no encontrada");
                }
            }
            else
            {
                lblMensajeBuscarRut.setText("Ingrese Rut");
            }
        }
        catch(Exception e)
        {
            lblMensajeBuscarRut.setText("Error");
        }
    }//GEN-LAST:event_btnBuscarTallerRutActionPerformed

    private void txtIdTallerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdTallerKeyTyped
        
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))
            || (vchar == KeyEvent.VK_BACK_SPACE)
            || (vchar == KeyEvent.VK_DELETE)){
        evt.consume();
        }
    
    }//GEN-LAST:event_txtIdTallerKeyTyped
    
    private String buscarTallerRut(String rut) throws SQLException
    {
        Connection cn = new FafricaConexion().Conectar();
        CallableStatement cs = cn.prepareCall("{call ? := F_BUSCAR_TALLER_RUT(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        
        cs.setString(2, rut);
        cs.executeUpdate();
        String salida = cs.getString(1);
        return salida;
    }
    private List<Empleado> buscarEmpleadoRut(String rut)
    {
        try {
            TypedQuery consulta = em.createNamedQuery("Empleado.findByRut", Empleado.class);
            List<Empleado> listEmp = consulta.setParameter("rut", rut).getResultList();
            
            if(listEmp.size() > 0)
            {
                return listEmp;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    private boolean camposVacios() {
        if(!txtNombre.getText().isEmpty() &&
            !txtFono.getText().isEmpty() &&
            !txtDireccion.getText().isEmpty() &&
            !txtRut.getText().isEmpty())
        {
            return true;
        }
        else
            return false;
    }
    
    private List<Taller> buscarTaller(String id)
    {
        try {
            TypedQuery consulta = em.createNamedQuery("Taller.findByIdTaller", Taller.class);
            List<Taller> listTaller = consulta.setParameter("idTaller", id).getResultList();
            
            if(listTaller.size() > 0)
            {
                return listTaller;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    private void llenarComboBoxRegiones()
    {
        TypedQuery consulta = em.createNamedQuery("Region.findAll", Region.class);
        List<Region> listRegion = consulta.getResultList();
        cbRegion.removeAllItems();
        if(listRegion.size() > 0)
        {
            for (Region region : listRegion) {
                cbRegion.addItem(region.getIdRegion()+" "+region.getNombre());
            }
        }
        else
        {
            cbRegion.addItem("Sin Datos");
        }
    }
    
    private void llenarComboBoxCiudades(int idregion)
    {
        TypedQuery consulta = em.createNamedQuery("Region.findByIdRegion", Region.class);
        List<Region> listRegion = consulta.setParameter("idRegion", idregion).getResultList();        
        cbCiudad.removeAllItems();
        if(listRegion.size() > 0)
        {
            for (Ciudad ciudad : listRegion.get(0).getCiudadCollection()) {
                cbCiudad.addItem(ciudad.getIdCiudad() +" "+ ciudad.getNombre());
            }
        }
        else
        {
            cbCiudad.addItem("Sin Datos");
        }
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscarTaller;
    private javax.swing.JButton btnBuscarTallerRut;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbCiudad;
    private javax.swing.JComboBox<String> cbRegion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensajeBuscar;
    private javax.swing.JLabel lblMensajeBuscarRut;
    private javax.swing.JTextArea txaMensaje;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFono;
    private javax.swing.JTextField txtIdTaller;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables

    
}
