/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Empleados;

import Datos.FafricaConexion;
import Entidades.Empleado;
import Entidades.Movimiento;
import Entidades.Pieza;
import Entidades.Presupuesto;
import Entidades.Siniestro;
import Entidades.Taller;
import Entidades.Vehiculo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author DarKMeYeR
 */
public class AvanceReparacionTaller extends javax.swing.JFrame {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeguroEscritorioPU");
    EntityManager em = emf.createEntityManager();
    String mensaje = "";
    Empleado adminTaller = null;
    Siniestro sin = null;
    List<Siniestro> listaSiniestros = null;
    String idpresupuesto = "";
    public AvanceReparacionTaller(Empleado emp) {
        initComponents();        
        adminTaller = emp;
        llenarcbSiniestros();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbEstadoFiltro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnCambiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNombrePieza = new javax.swing.JTextField();
        cbPiezas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtCostoPieza = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarPieza = new javax.swing.JButton();
        btnEliminarPieza = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbSiniestros = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaMensaje = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Avance Reparaciones Taller");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        cbEstadoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Recepcion", "Ingresado", "Evaluacion", "Reparacion", "Retrasado", "Reingresado", "Finalizado", "Entregado" }));
        cbEstadoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoFiltroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Filtrar Estado:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Resultados:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recepcion", "Ingresado", "Evaluacion", "Reparacion", "Finalizado", "Entregado" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cambiar Estado:");

        txtComentario.setColumns(20);
        txtComentario.setLineWrap(true);
        txtComentario.setRows(5);
        jScrollPane2.setViewportView(txtComentario);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Comentario:");

        btnCambiar.setText("CAMBIAR");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Piezas:");

        txtNombrePieza.setEnabled(false);

        cbPiezas.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre:");

        txtCostoPieza.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Costo:");

        btnAgregarPieza.setText("AGREGAR");
        btnAgregarPieza.setEnabled(false);
        btnAgregarPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPiezaActionPerformed(evt);
            }
        });

        btnEliminarPieza.setText("ELIMINAR");
        btnEliminarPieza.setEnabled(false);
        btnEliminarPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPiezaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ESTADO:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PIEZAS:");

        cbSiniestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSiniestrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombrePieza)
                                    .addComponent(cbPiezas, 0, 141, Short.MAX_VALUE)
                                    .addComponent(txtCostoPieza)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCambiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarPieza)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarPieza)))
                        .addGap(115, 115, 115))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 75, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstadoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbSiniestros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstadoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbSiniestros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombrePieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCostoPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiar)
                    .addComponent(btnAgregarPieza)
                    .addComponent(btnEliminarPieza))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        txaMensaje.setColumns(20);
        txaMensaje.setRows(5);
        jScrollPane3.setViewportView(txaMensaje);

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        mensaje = "";
        txaMensaje.setText(mensaje);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbEstadoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoFiltroActionPerformed
        llenarcbSiniestros();
    }//GEN-LAST:event_cbEstadoFiltroActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        try {
            if(!txtComentario.getText().isEmpty())
            {
                sin.setEstado(cbEstado.getSelectedItem().toString());
                Movimiento mov = new Movimiento();
                mov.setDescripcion(txtComentario.getText());
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar calNow = Calendar.getInstance();
                calNow.add(Calendar.MONTH, +1);
                Date date1 = calNow.getTime();
                String fechaActual = sdf.format(date1);
                mov.setFecha(sdf.parse(fechaActual));
                mov.setSiniestroIdSiniestro(sin);

                em.getTransaction().begin();
                em.merge(sin);
                em.getTransaction().commit();

                Connection cn = new FafricaConexion().Conectar();
                CallableStatement cs = cn.prepareCall("{call ? := F_INSERT_MOVIMIENTO(?,?,?)}");
                cs.registerOutParameter(1, Types.VARCHAR);

                java.sql.Date sqlDate = new java.sql.Date(mov.getFecha().getTime());
                cs.setDate(2, sqlDate);
                cs.setString(3, mov.getDescripcion());
                cs.setString(4, mov.getSiniestroIdSiniestro().getIdSiniestro());
                cs.executeUpdate();
                String mensaje2 = cs.getString(1);
                mensaje += mensaje2+" \n";
                txaMensaje.setText(mensaje);
            }
            else
            {
                mensaje += "Escriba Su Comentario \n";
                txaMensaje.setText(mensaje); 
            }
        } catch (Exception e) {
            mensaje += e.getMessage()+" \n";
            txaMensaje.setText(mensaje);
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void cbSiniestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSiniestrosActionPerformed
        try {
            sin = null;
            String[] itemSplit = cbSiniestros.getSelectedItem().toString().split("\\s+");
            for (Siniestro listaSiniestro : listaSiniestros) {
                if(listaSiniestro.getPatente().equals(itemSplit[1]))
                    sin = listaSiniestro;
            }
            if(sin != null)
            {
                cbEstado.setSelectedItem(sin.getEstado());
                idpresupuesto = sin.getClienteIdCliente().getIdCliente()+"-"+sin.getIdSiniestro();
                if(sin.getEstado().equals("Evaluacion"))
                {
                    cbPiezas.setEnabled(true);
                    txtNombrePieza.setEnabled(true);
                    txtCostoPieza.setEnabled(true);
                    btnAgregarPieza.setEnabled(true);
                    btnEliminarPieza.setEnabled(true);
                    llenarcbpiezas(buscarPiezas());
                }
                else
                {
                    cbPiezas.setEnabled(false);
                    txtNombrePieza.setEnabled(false);
                    txtCostoPieza.setEnabled(false);
                    btnAgregarPieza.setEnabled(false);
                    btnEliminarPieza.setEnabled(false);
                }
            }
            else
            {
                cbPiezas.setEnabled(false);
                txtNombrePieza.setEnabled(false);
                txtCostoPieza.setEnabled(false);
                btnAgregarPieza.setEnabled(false);
                btnEliminarPieza.setEnabled(false);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbSiniestrosActionPerformed

    private void btnAgregarPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPiezaActionPerformed
        try {
            if(!txtNombrePieza.getText().isEmpty() || !txtCostoPieza.getText().isEmpty())
            {
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                Calendar calNow = Calendar.getInstance();
                calNow.add(Calendar.MONTH, +1);
                Date date1 = calNow.getTime();
                String fechaActual = sdf.format(date1);

                Presupuesto pre = new Presupuesto();
                pre.setIdPresupuesto(idpresupuesto);
                pre.setFecha(sdf.parse(fechaActual));
                pre.setVehiculoIdVehiculo(buscarPatente(sin.getPatente()).get(0));

                Pieza pieza = new Pieza();
                pieza.setNombre(txtNombrePieza.getText());
                pieza.setValor(Integer.parseInt(txtCostoPieza.getText()));
                pieza.setPresupuestoIdPresupuesto(pre);

                Connection cn = new FafricaConexion().Conectar();
                CallableStatement cs = cn.prepareCall("{call ? := F_INSERT_PRESUPUESTO(?,?,?,?,?,?)}");
                cs.registerOutParameter(1, Types.VARCHAR);            
                java.sql.Date sqlDate = new java.sql.Date(pre.getFecha().getTime());

                cs.setString(2, pre.getIdPresupuesto());
                cs.setString(3, pre.getVehiculoIdVehiculo().getIdVehiculo());
                cs.setDate(4, sqlDate);
                cs.setString(5, "");
                cs.setString(6, pieza.getNombre());
                cs.setInt(7, (int)pieza.getValor());
                cs.executeUpdate();
                llenarcbpiezas(buscarPiezas());
                String mensaje2 = cs.getString(1);           

                mensaje += mensaje2+" \n";
                txaMensaje.setText(mensaje);
                GenerarPresupuesto(idpresupuesto);
            }
            else
            {
                mensaje += "Llene todos los Campos \n";
                txaMensaje.setText(mensaje);
            }
        } catch (Exception e) {
            mensaje += e.getMessage()+" \n";
            txaMensaje.setText(mensaje);
        }
    }//GEN-LAST:event_btnAgregarPiezaActionPerformed

    private void btnEliminarPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPiezaActionPerformed
        try {
            if(cbPiezas.getItemCount() > 0)
            {
                String[] itemSplit = cbPiezas.getSelectedItem().toString().split("\\s+");
                long idPieza = Long.parseLong(itemSplit[0]);
                Pieza pieza = buscarPiezaId(idPieza).get(0);

                em.getTransaction().begin();
                em.remove(pieza);
                em.getTransaction().commit();
                llenarcbpiezas(buscarPiezas());
                mensaje += "Pieza Eliminada \n";
                txaMensaje.setText(mensaje);
                GenerarPresupuesto(idpresupuesto);
            }
        } catch (Exception e) {
            txaMensaje.setText(e.getMessage()); 
        }
    }//GEN-LAST:event_btnEliminarPiezaActionPerformed
    
    private List<Pieza> buscarPiezas()
    {
        try {
            TypedQuery consulta = em.createNamedQuery("Pieza.findAll", Vehiculo.class);
            List<Pieza> listPieza = consulta.getResultList();
            
            if(listPieza.size() > 0)
            {
                return listPieza;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    private void llenarcbpiezas(List<Pieza> lista)
    {
        try {
            cbPiezas.removeAllItems();
            for (Pieza pieza : lista) {
                if(pieza.getPresupuestoIdPresupuesto().getIdPresupuesto().equals(sin.getClienteIdCliente().getIdCliente()+"-"+sin.getIdSiniestro()))
                    cbPiezas.addItem(pieza.getIdPieza()+" "+pieza.getNombre());
            }
        } catch (Exception e) {
        }
    }
    private List<Vehiculo> buscarPatente(String patente)
    {
        try {
            TypedQuery consulta = em.createNamedQuery("Vehiculo.findByPatente", Vehiculo.class);
            List<Vehiculo> listVehiculo = consulta.setParameter("patente", patente).getResultList();
            
            if(listVehiculo.size() > 0)
            {
                return listVehiculo;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    private void llenarcbSiniestros()
    {
        cbSiniestros.removeAllItems();
        List<Siniestro> listaSiniestro = buscarSiniestros(adminTaller);
        if(listaSiniestro != null)
        {
            if(cbEstadoFiltro.getSelectedItem().toString().equals("Todos"))
            {       
                for (Siniestro siniestro : listaSiniestro) {
                    cbSiniestros.addItem("Patente: "+siniestro.getPatente()+" Rut: "+siniestro.getClienteIdCliente().getRut());
                }
            }
            else
            {
                if(listaSiniestro != null)
                {
                    for (Siniestro siniestro : listaSiniestro) {
                        if(siniestro.getEstado().equals(cbEstadoFiltro.getSelectedItem().toString()))
                            cbSiniestros.addItem("Patente: "+siniestro.getPatente()+" Rut: "+siniestro.getClienteIdCliente().getRut());
                    }
                    if(cbSiniestros.getItemCount() == 0)
                        cbSiniestros.addItem("Sin Vehiculos");
                }
            }
        }
        else
            cbSiniestros.addItem("Sin Vehiculos"); 
    }
    
    public List<Siniestro> buscarSiniestroxTaller(Taller taller)
    {
        try {
            TypedQuery consulta = em.createNamedQuery("Siniestro.findByTaller", Siniestro.class);
            List<Siniestro> listSiniestros = consulta.setParameter("tallerIdTaller", taller).getResultList();
            
            if(listSiniestros.size() > 0)
            {
                return listSiniestros;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Taller> buscarTallerxEmpleado(Empleado emp)
    {
        try {
            TypedQuery consulta = em.createNamedQuery("Taller.findByEmpleado", Taller.class);
            List<Taller> listTaller = consulta.setParameter("empleadoIdEmpleado", emp).getResultList();
            
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
    
    public List<Presupuesto> buscarPresupuestoId(String id)
    {
        try {
            TypedQuery consulta = em.createNamedQuery("Presupuesto.findByIdPresupuesto", Presupuesto.class);
            List<Presupuesto> listPresupuesto = consulta.setParameter("idPresupuesto", id).getResultList();
            
            if(listPresupuesto.size() > 0)
            {
                return listPresupuesto;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    private List<Pieza> buscarPiezaId(long idPieza) {
        try {
            TypedQuery consulta = em.createNamedQuery("Pieza.findByIdPieza", Pieza.class);
            List<Pieza> listPieza = consulta.setParameter("idPieza", idPieza).getResultList();
            
            if(listPieza.size() > 0)
            {
                return listPieza;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Pieza> buscarPiezaPresupuesto(Presupuesto pre)
    {
        try {
            TypedQuery consulta = em.createNamedQuery("Pieza.findByPresupuesto", Pieza.class);
            List<Pieza> listPieza = consulta.setParameter("presupuestoIdPresupuesto", pre).getResultList();
            
            if(listPieza.size() > 0)
            {
                return listPieza;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Siniestro> buscarSiniestros(Empleado emp)
    {
        listaSiniestros = buscarSiniestroxTaller(buscarTallerxEmpleado(emp).get(0));
        return listaSiniestros;
    }
    
    private void GenerarPresupuesto(String idpresupuesto) {
        Presupuesto pre = buscarPresupuestoId(idpresupuesto).get(0);
        List<Pieza> listPieza = buscarPiezaPresupuesto(pre);
        List<Siniestro> listSiniestro = buscarSiniestros(adminTaller);
        Siniestro siniestro = null;
        for (Siniestro aux : listSiniestro) {
            if(aux.getPatente().equals(pre.getVehiculoIdVehiculo().getPatente()))
                siniestro = aux;
        }
        String doc = "";
        doc += "******************************************PRESUPUESTO********************************************\n";
        doc += "                                                                                                       \n";
        doc += "Nombre: "+pre.getVehiculoIdVehiculo().getClienteIdCliente().getNombres()+" "+pre.getVehiculoIdVehiculo().getClienteIdCliente().getApellidos()+"          \t \t Direccion: "+pre.getVehiculoIdVehiculo().getClienteIdCliente().getDireccion()+"\n";
        doc += "Rut: "+pre.getVehiculoIdVehiculo().getClienteIdCliente().getRut()+"                                           \t Correo: "+pre.getVehiculoIdVehiculo().getClienteIdCliente().getCorreo()+"\n";
        doc += "                                                                                                      \n";
        doc += "********************************************TALLER*****************************************************\n";
        doc += "Taller:"+siniestro.getTallerIdTaller().getNombre()+" \t Fono: "+siniestro.getTallerIdTaller().getFono() +"\n";
        doc += "Direccion: "+siniestro.getTallerIdTaller().getDireccion()+" \t Admin Taller: "+siniestro.getTallerIdTaller().getEmpleadoIdEmpleado().getNombres()+" "+siniestro.getTallerIdTaller().getEmpleadoIdEmpleado().getApellidos()+"\n";
        doc += "Ciudad: "+siniestro.getTallerIdTaller().getCiudadIdCiudad().getNombre() +"\n";
        doc += "                                                                                                              \n";
        doc += "*******************************************VEHICULO**********************************************\n";
        doc += "Marca: "+pre.getVehiculoIdVehiculo().getModeloIdModelo().getMarcaIdMarca().getNombre()+"                            \t \t Modelo: "+pre.getVehiculoIdVehiculo().getModeloIdModelo().getNombre()+" \n";
                        doc += "Patente: "+pre.getVehiculoIdVehiculo().getPatente()+"                             \t \t Año: "+pre.getVehiculoIdVehiculo().getAno()+" \n";
                        doc += "Valor Fiscal : $"+pre.getVehiculoIdVehiculo().getValorFiscal()+"                             \n";
        doc += "                                                                                                              \n";
        doc += "********************************************PIEZAS****************************************************\n";
        for (Pieza pieza : listPieza) {
            doc += pieza.getNombre()+" \t\t"+pieza.getValor()+"\n";
        }
        doc += "********************************************PIEZAS****************************************************\n";
        String indented = doc.replaceAll("(?m)^", "\t");
        
        try {
            String contenido=indented;
            FileOutputStream archivo = new FileOutputStream("C:\\pre"+pre.getIdPresupuesto()+".pdf");
            Document docu = new Document();
            PdfWriter.getInstance(docu, archivo);
            docu.open();
            docu.add(new Paragraph(contenido));

            docu.close();
            mensaje += "pdf presupuesto Generado/Actualizado: pre"+pre.getIdPresupuesto()+".pdf \n";
            txaMensaje.setText(mensaje);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPieza;
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnEliminarPieza;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbEstadoFiltro;
    private javax.swing.JComboBox<String> cbPiezas;
    private javax.swing.JComboBox<String> cbSiniestros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txaMensaje;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtCostoPieza;
    private javax.swing.JTextField txtNombrePieza;
    // End of variables declaration//GEN-END:variables

    

    
}
