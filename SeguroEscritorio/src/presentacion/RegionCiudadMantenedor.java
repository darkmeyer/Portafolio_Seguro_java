/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import Entidades.*;
import java.sql.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.DefaultComboBoxModel;
import Datos.FafricaConexion;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author DarKMeYeR
 */
public class RegionCiudadMantenedor extends javax.swing.JFrame {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguroEscritorioPU");
    EntityManager em = emf.createEntityManager();
    public RegionCiudadMantenedor() {
        initComponents();
        llenarComboBoxRegiones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreRegion = new javax.swing.JTextField();
        btnBuscarRegion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIdRegion = new javax.swing.JTextField();
        lblBuscarCiudad = new javax.swing.JLabel();
        cbRegion = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreCiudad = new javax.swing.JTextField();
        txtIdCiudad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBuscarCiudad = new javax.swing.JButton();
        lblBuscarRegion = new javax.swing.JLabel();
        btnActualizarRegion = new javax.swing.JButton();
        btnIngresarRegion = new javax.swing.JButton();
        btnBorrarRegion = new javax.swing.JButton();
        lblMensajeRegion = new javax.swing.JLabel();
        lblMensajeCiudad = new javax.swing.JLabel();
        btnIngresarCiudad = new javax.swing.JButton();
        btnActualizarCiudad = new javax.swing.JButton();
        btnBorrarCiudad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenedor Regiones y Ciudades");

        jLabel3.setText("Nombre:");

        btnBuscarRegion.setText("Buscar");
        btnBuscarRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRegionActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("REGION:");

        txtIdRegion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtIdRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdRegionActionPerformed(evt);
            }
        });
        txtIdRegion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdRegionKeyTyped(evt);
            }
        });

        jLabel7.setText("Region:");

        jLabel5.setText("Nombre:");

        txtIdCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCiudadActionPerformed(evt);
            }
        });
        txtIdCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdCiudadKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("CIUDAD:");

        jLabel6.setText("ID:");

        btnBuscarCiudad.setText("Buscar");
        btnBuscarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCiudadActionPerformed(evt);
            }
        });

        btnActualizarRegion.setText("Actualizar");
        btnActualizarRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRegionActionPerformed(evt);
            }
        });

        btnIngresarRegion.setText("Ingresar");
        btnIngresarRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarRegionActionPerformed(evt);
            }
        });

        btnBorrarRegion.setText("Borrar");
        btnBorrarRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarRegionActionPerformed(evt);
            }
        });

        btnIngresarCiudad.setText("Ingresar");
        btnIngresarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarCiudadActionPerformed(evt);
            }
        });

        btnActualizarCiudad.setText("Actualizar");
        btnActualizarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCiudadActionPerformed(evt);
            }
        });

        btnBorrarCiudad.setText("Borrar");
        btnBorrarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtIdRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnBuscarRegion))
                                            .addComponent(txtNombreRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblBuscarRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtIdCiudad)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(btnBuscarCiudad))
                                                .addComponent(txtNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblBuscarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(jLabel4)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIngresarCiudad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarCiudad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarCiudad))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIngresarRegion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarRegion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarRegion)))
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensajeCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensajeRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarRegion)
                        .addComponent(jLabel2))
                    .addComponent(lblBuscarRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarRegion)
                    .addComponent(btnIngresarRegion)
                    .addComponent(btnBorrarRegion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensajeRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btnBuscarCiudad)))
                    .addComponent(lblBuscarCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarCiudad)
                    .addComponent(btnIngresarCiudad)
                    .addComponent(btnBorrarCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensajeCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCiudadActionPerformed

    private void txtIdRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRegionActionPerformed

    private void btnBuscarRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRegionActionPerformed
        try
        {
            if(!txtIdRegion.getText().isEmpty())
            {
                int idRegion = Integer.parseInt(txtIdRegion.getText());  
                List<Region> lista = buscarRegion(idRegion);
                if(lista != null)
                {
                    txtNombreRegion.setText(lista.get(0).getNombre());
                    lblBuscarRegion.setText("ID encontrada");
                }
                else
                {
                    lblBuscarRegion.setText("ID no encontrada");
                }
            }
            else
            {
                lblBuscarRegion.setText("Ingrese ID");
            }
        }
        catch(Exception e)
        {
            lblBuscarRegion.setText("Error");
        }
    }//GEN-LAST:event_btnBuscarRegionActionPerformed

    private void btnBuscarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCiudadActionPerformed
        try
        {
            if(!txtIdCiudad.getText().isEmpty())
            {
                int idCiudad = Integer.parseInt(txtIdCiudad.getText());
                List<Ciudad> listCiudad = buscarCiudad(idCiudad);
                if(listCiudad != null)
                {
                    txtNombreCiudad.setText(listCiudad.get(0).getNombre());
                    cbRegion.setSelectedItem(listCiudad.get(0).getRegionIdRegion().getIdRegion()+" "+listCiudad.get(0).getRegionIdRegion().getNombre());
                    lblBuscarCiudad.setText("ID encontrada");
                }
                else
                {
                    lblBuscarCiudad.setText("ID no encontrada");
                }
            }
            else
            {
                lblBuscarCiudad.setText("Ingrese ID");
            }
        }
        catch(Exception e)
        {
            lblBuscarCiudad.setText("Error");
        }
    }//GEN-LAST:event_btnBuscarCiudadActionPerformed

    private void btnIngresarRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarRegionActionPerformed
        try
        {
            if(!txtIdRegion.getText().isEmpty() && !txtNombreRegion.getText().isEmpty())
            {
                int id = Integer.parseInt(txtIdRegion.getText());
                String nombre = txtNombreRegion.getText();
                Connection cn = new FafricaConexion().Conectar();
                try {

                    CallableStatement cs = cn.prepareCall("{call ? := F_INSERT_REGION(?,?)}");
                    cs.registerOutParameter(1, Types.VARCHAR);
                    cs.setInt(2, id);
                    cs.setString(3, nombre);
                    cs.executeUpdate();
                    String mensaje = cs.getString(1);
                    lblMensajeRegion.setText(mensaje);
                    llenarComboBoxRegiones();
                } catch (Exception e) {
                }
            }
            else
            {
                lblMensajeRegion.setText("Llene los campos");
            }
        }
        catch(Exception e)
        {
            lblMensajeRegion.setText("Error");
        }
    }//GEN-LAST:event_btnIngresarRegionActionPerformed

    private void txtIdRegionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdRegionKeyTyped
        TextFieldNumber(evt);
    }//GEN-LAST:event_txtIdRegionKeyTyped

    private void btnActualizarRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRegionActionPerformed
        try
        {
            if(!txtIdRegion.getText().isEmpty() && !txtNombreRegion.getText().isEmpty())
            {
                short id = Short.parseShort(txtIdRegion.getText());
                String nombre = txtNombreRegion.getText();            
                Connection cn = new FafricaConexion().Conectar();
                try {
                    if(buscarRegion(id) != null)
                    {
                        Region reg = new Region();
                        reg.setIdRegion(id);
                        reg.setNombre(nombre);

                        em.getTransaction().begin();
                        em.merge(reg);
                        em.getTransaction().commit();

                        /*
                        CallableStatement cs = cn.prepareCall("{call ? := F_UPDATE_REGION(?,?)}");
                        cs.registerOutParameter(1, Types.VARCHAR);
                        cs.setInt(2, id);
                        cs.setString(3, nombre);
                        cs.executeUpdate();
                        String mensaje = cs.getString(1);
                        */
                        lblMensajeRegion.setText("Region Actualizada");
                        llenarComboBoxRegiones();
                    }
                    else
                    {
                        lblMensajeRegion.setText("ID Region no existe");
                    }
                } catch (Exception e) {
                }
            }
            else
            {
                lblMensajeRegion.setText("Llene los campos");
            }
        }
        catch(Exception e)
        {
            lblMensajeRegion.setText("Error");
        }
    }//GEN-LAST:event_btnActualizarRegionActionPerformed

    private void btnBorrarRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarRegionActionPerformed
        try
        {
            if(!txtIdRegion.getText().isEmpty())
            {    
                int id = Integer.parseInt(txtIdRegion.getText());
                List<Region> listReg = buscarRegion(id);
                if(listReg != null)
                {
                    em.getTransaction().begin();
                    em.remove(listReg.get(0));
                    em.getTransaction().commit();
                    lblMensajeRegion.setText("Region Eliminada");
                    llenarComboBoxRegiones();
                    txtIdRegion.setText("");
                    txtNombreRegion.setText("");
                }
                else
                {
                    lblMensajeRegion.setText("Region No existe");
                }
            }
            else
            {
                lblMensajeRegion.setText("Ingrese la ID");
            } 
        }
        catch(Exception e)
        {
            lblMensajeRegion.setText("Error");
        }
    }//GEN-LAST:event_btnBorrarRegionActionPerformed

    private void btnIngresarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarCiudadActionPerformed
        try
        {
            if(!txtIdCiudad.getText().isEmpty() && !txtNombreCiudad.getText().isEmpty())
            {
                int id = Integer.parseInt(txtIdCiudad.getText());
                String nombre = txtNombreCiudad.getText();
                String item = cbRegion.getSelectedItem().toString();
                String[] itemSplit = item.split("\\s+");
                int idRegion = Integer.parseInt(itemSplit[0]);
                Connection cn = new FafricaConexion().Conectar();
                try {

                    CallableStatement cs = cn.prepareCall("{call ? := F_INSERT_CIUDAD(?,?,?)}");
                    cs.registerOutParameter(1, Types.VARCHAR);
                    cs.setInt(2, id);
                    cs.setString(3, nombre);
                    cs.setInt(4, idRegion);
                    cs.executeUpdate();
                    String mensaje = cs.getString(1);
                    lblMensajeCiudad.setText(mensaje);
                    llenarComboBoxRegiones();
                } catch (Exception e) {
                }
            }
            else
            {
                lblMensajeCiudad.setText("Llene los campos");
            }
        }
        catch(Exception e)
        {
            lblMensajeCiudad.setText("Error");
        }
    }//GEN-LAST:event_btnIngresarCiudadActionPerformed

    private void btnActualizarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCiudadActionPerformed
        try
        {
            if(!txtIdCiudad.getText().isEmpty() && !txtNombreCiudad.getText().isEmpty())
            {
                short id = Short.parseShort(txtIdCiudad.getText());
                String nombre = txtNombreCiudad.getText();
                String item = cbRegion.getSelectedItem().toString();
                String[] itemSplit = item.split("\\s+");
                short idRegion = Short.parseShort(itemSplit[0]);        
                Connection cn = new FafricaConexion().Conectar();
                try {
                    if(buscarCiudad(id) != null)
                    {
                        Ciudad ciudad = new Ciudad();
                        ciudad.setIdCiudad(id);
                        ciudad.setNombre(nombre);
                        Region reg = new Region();
                        reg.setIdRegion(idRegion);
                        ciudad.setRegionIdRegion(reg);
                        em.getTransaction().begin();
                        em.merge(ciudad);
                        em.getTransaction().commit();

                        /*
                        CallableStatement cs = cn.prepareCall("{call ? := F_UPDATE_REGION(?,?)}");
                        cs.registerOutParameter(1, Types.VARCHAR);
                        cs.setInt(2, id);
                        cs.setString(3, nombre);
                        cs.executeUpdate();
                        String mensaje = cs.getString(1);
                        */
                        lblMensajeCiudad.setText("Ciudad Actualizada");
                    }
                    else
                    {
                        lblMensajeCiudad.setText("ID Ciudad no existe");
                    }
                } catch (Exception e) {
                }
            }
            else
            {
                lblMensajeCiudad.setText("Llene los campos");
            }
        }
        catch(Exception e)
        {
            lblMensajeCiudad.setText("Llene los campos");
        }
    }//GEN-LAST:event_btnActualizarCiudadActionPerformed

    private void btnBorrarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCiudadActionPerformed
        try
        {
            if(!txtIdCiudad.getText().isEmpty())
            {    
                int id = Integer.parseInt(txtIdCiudad.getText());
                List<Ciudad> listCiudad = buscarCiudad(id);
                if(listCiudad != null)
                {
                    em.getTransaction().begin();
                    em.remove(listCiudad.get(0));
                    em.getTransaction().commit();
                    lblMensajeCiudad.setText("Ciudad Eliminada");
                    txtIdCiudad.setText("");
                    txtNombreCiudad.setText("");
                }
                else
                {
                    lblMensajeCiudad.setText("Ciudad No existe");
                }
            }
            else
            {
                lblMensajeCiudad.setText("Ingrese la ID");
            }
        }
        catch(Exception e)
        {
            lblMensajeCiudad.setText("Error");
        }
    }//GEN-LAST:event_btnBorrarCiudadActionPerformed

    private void txtIdCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCiudadKeyTyped
        TextFieldNumber(evt);
    }//GEN-LAST:event_txtIdCiudadKeyTyped
    
    
    private void TextFieldNumber(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))
            || (vchar == KeyEvent.VK_BACK_SPACE)
            || (vchar == KeyEvent.VK_DELETE)){
        evt.consume();
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
    }
    
    private List<Ciudad> buscarCiudad(int id)
    {
        TypedQuery consulta = em.createNamedQuery("Ciudad.findByIdCiudad", Ciudad.class);
        List<Ciudad> listCiudad = consulta.setParameter("idCiudad", id).getResultList();

        if(listCiudad.size() > 0)
        {
            return listCiudad;
        }
        else
        {
            return null;
        }
    }
    
    private List<Region> buscarRegion(int id)
    {
        TypedQuery consulta = em.createNamedQuery("Region.findByIdRegion", Region.class);
        List<Region> listRegion = consulta.setParameter("idRegion", id).getResultList();

        if(listRegion.size() > 0)
        {
            return listRegion;
        }
        else
        {
            return null;
        }        
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegionCiudadMantenedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCiudad;
    private javax.swing.JButton btnActualizarRegion;
    private javax.swing.JButton btnBorrarCiudad;
    private javax.swing.JButton btnBorrarRegion;
    private javax.swing.JButton btnBuscarCiudad;
    private javax.swing.JButton btnBuscarRegion;
    private javax.swing.JButton btnIngresarCiudad;
    private javax.swing.JButton btnIngresarRegion;
    private javax.swing.JComboBox<String> cbRegion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBuscarCiudad;
    private javax.swing.JLabel lblBuscarRegion;
    private javax.swing.JLabel lblMensajeCiudad;
    private javax.swing.JLabel lblMensajeRegion;
    private javax.swing.JTextField txtIdCiudad;
    private javax.swing.JTextField txtIdRegion;
    private javax.swing.JTextField txtNombreCiudad;
    private javax.swing.JTextField txtNombreRegion;
    // End of variables declaration//GEN-END:variables

    
}
