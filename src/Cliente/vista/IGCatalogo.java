package Cliente.vista;

import Cliente.controlador.ControlCatalogo;
import Cliente.controlador.TicketPDF;
import Cliente.modelo.*;
import com.itextpdf.text.DocumentException;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IGCatalogo extends javax.swing.JFrame {

    private Cliente cliente;
    private int anterior, siguiente, actual,numero;
    private ArrayList<Zapato> catalogo;
    private Zapato zapaton;
    private SocketEnvioRecibo enviarRecibir;
    private ArrayList<Compra> lista;
    private BufferedImage[] imagenes;

    public SocketEnvioRecibo getEnviarRecibir() {
        return enviarRecibir;
    }

    public void setEnviarRecibir(SocketEnvioRecibo enviarRecibir) {
        this.enviarRecibir = enviarRecibir;
        catalogo.add(new Zapato());//solo es un señuelo
        try {
            catalogo = enviarRecibir.pedirCatalogo(catalogo);
            ControlCatalogo.colocarCatalogo(catalogo, zapaton, textoId, textoDesc, textoPrecio, textoExitencia, botonAnterior);
            zapaton = catalogo.get(0);
            imagenes = ControlCatalogo.cargarImagenes(catalogo, imagenes);
            imagen.setIcon(new ImageIcon(imagenes[0]));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        ControlCatalogo.imprimirDatosCliente(cliente, etiquetaNombre, etiquetaDatos);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public IGCatalogo() {
        initComponents();
        catalogo = new ArrayList<>(); 
        lista = new ArrayList();
        anterior = -1;
        actual = 0;
        siguiente = 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelPerfil = new javax.swing.JPanel();
        botonCerrar = new javax.swing.JButton();
        etiquetaCliente = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaDatos = new javax.swing.JLabel();
        panelCatalogo = new javax.swing.JPanel();
        cantidad = new javax.swing.JSpinner();
        imagen = new javax.swing.JLabel();
        botonAnterior = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        etiquetaDesc = new javax.swing.JLabel();
        etiquetaExistencia = new javax.swing.JLabel();
        etiquetasTallas = new javax.swing.JLabel();
        etiquetaPrecio = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        etiquetaCantidad = new javax.swing.JLabel();
        part1 = new javax.swing.JLabel();
        part2 = new javax.swing.JLabel();
        textoDesc = new javax.swing.JLabel();
        textoExitencia = new javax.swing.JLabel();
        textoPrecio = new javax.swing.JLabel();
        etiquetaId = new javax.swing.JLabel();
        textoId = new javax.swing.JLabel();
        panelCarrito = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        botonCompra = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalogo");
        setResizable(false);

        botonCerrar.setText("Cerrar Session");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        etiquetaCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hyper\\Documents\\NetBeansProjects\\2PracticaAPCR\\src\\Cliente\\imagenes\\login.png")); // NOI18N

        etiquetaNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiquetaNombre.setText("Nombre: ");

        etiquetaDatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiquetaDatos.setText("Datos: ");

        javax.swing.GroupLayout panelPerfilLayout = new javax.swing.GroupLayout(panelPerfil);
        panelPerfil.setLayout(panelPerfilLayout);
        panelPerfilLayout.setHorizontalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addComponent(etiquetaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botonCerrar))
                .addGap(271, 271, 271))
        );
        panelPerfilLayout.setVerticalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addComponent(etiquetaNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaDatos)))
                .addGap(33, 33, 33)
                .addComponent(botonCerrar)
                .addGap(164, 164, 164))
        );

        jTabbedPane1.addTab("Ver perfil", panelPerfil);

        cantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        imagen.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hyper\\Documents\\NetBeansProjects\\2PracticaAPCR\\imagenes\\main.jpg")); // NOI18N

        botonAnterior.setText("Anterior");
        botonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnteriorActionPerformed(evt);
            }
        });

        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        etiquetaDesc.setText("Descripcion:");

        etiquetaExistencia.setText("Existencias:");

        etiquetasTallas.setText("Tallas: 22-27");

        etiquetaPrecio.setText("Precio:");

        botonAgregar.setText("AGREGAR A CARRITO");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        etiquetaCantidad.setText("Cantidad");

        part1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        part1.setText("Eliga la cantidad de productos que desea");

        part2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        part2.setText("agregar al carrito.");

        textoDesc.setText("jLabel1");

        textoExitencia.setText("jLabel2");

        textoPrecio.setText("jLabel3");

        etiquetaId.setText("Id:");

        textoId.setText("jLabel1");

        javax.swing.GroupLayout panelCatalogoLayout = new javax.swing.GroupLayout(panelCatalogo);
        panelCatalogo.setLayout(panelCatalogoLayout);
        panelCatalogoLayout.setHorizontalGroup(
            panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCatalogoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCatalogoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(panelCatalogoLayout.createSequentialGroup()
                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCatalogoLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetasTallas)
                                    .addComponent(etiquetaCantidad)
                                    .addGroup(panelCatalogoLayout.createSequentialGroup()
                                        .addComponent(botonAnterior)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botonSiguiente))
                                    .addGroup(panelCatalogoLayout.createSequentialGroup()
                                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiquetaExistencia)
                                            .addComponent(etiquetaDesc)
                                            .addComponent(etiquetaPrecio)
                                            .addComponent(etiquetaId))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textoDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                            .addComponent(textoExitencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textoPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textoId)))))
                            .addGroup(panelCatalogoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(part2)
                                    .addComponent(part1)
                                    .addComponent(botonAgregar))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelCatalogoLayout.setVerticalGroup(
            panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCatalogoLayout.createSequentialGroup()
                .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCatalogoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonSiguiente)
                            .addComponent(botonAnterior))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(part1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(part2)
                        .addGap(18, 18, 18)
                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaId)
                            .addComponent(textoId))
                        .addGap(18, 18, 18)
                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaDesc)
                            .addComponent(textoDesc))
                        .addGap(18, 18, 18)
                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaExistencia)
                            .addComponent(textoExitencia))
                        .addGap(18, 18, 18)
                        .addComponent(etiquetasTallas)
                        .addGap(18, 18, 18)
                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaPrecio)
                            .addComponent(textoPrecio))
                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCatalogoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCatalogoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiquetaCantidad)))
                        .addGap(39, 39, 39)
                        .addComponent(botonAgregar))
                    .addGroup(panelCatalogoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Ver Catalogo", panelCatalogo);

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Zapato", "Cantidad", "Precio Unitario", "Precio Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCarrito);
        if (tablaCarrito.getColumnModel().getColumnCount() > 0) {
            tablaCarrito.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        botonCompra.setText("Finalizar Compra");
        botonCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompraActionPerformed(evt);
            }
        });

        botonQuitar.setText("Quitar");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCarritoLayout = new javax.swing.GroupLayout(panelCarrito);
        panelCarrito.setLayout(panelCarritoLayout);
        panelCarritoLayout.setHorizontalGroup(
            panelCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarritoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCarritoLayout.createSequentialGroup()
                        .addComponent(botonQuitar)
                        .addGap(29, 29, 29)
                        .addComponent(botonCompra)))
                .addGap(19, 19, 19))
        );
        panelCarritoLayout.setVerticalGroup(
            panelCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarritoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelCarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCompra)
                    .addComponent(botonQuitar))
                .addGap(142, 142, 142))
        );

        jTabbedPane1.addTab("Carrito de Compra", panelCarrito);

        jTabbedPane1.setSelectedIndex(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        // Cerrar esta ventana y mandar a cerrar session
        Login login = new Login();
        login.setVisible(true);
        enviarRecibir.cerrarSession();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        // TODO add your handling code here:
        zapaton = catalogo.get(siguiente);
        imagen.setIcon(new ImageIcon(imagenes[siguiente]));
        siguiente++;
        anterior++;
        actual++;
        ControlCatalogo.siguiente(botonAnterior, botonSiguiente, zapaton, textoId, textoDesc, textoPrecio, textoExitencia, siguiente,catalogo.size());
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed
        // TODO add your handling code here:
        zapaton = catalogo.get(anterior);
        imagen.setIcon(new ImageIcon(imagenes[anterior]));
        siguiente--;
        anterior--;
        actual--;
        ControlCatalogo.anterior(botonAnterior, botonSiguiente, zapaton, textoId, textoDesc, textoPrecio, textoExitencia, anterior);
    }//GEN-LAST:event_botonAnteriorActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // Agregar al carrito
        ControlCatalogo.agregarALaTabla(catalogo, tablaCarrito, zapaton, lista, cantidad, actual, textoExitencia);
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        // TODO add your handling code here:
        ControlCatalogo.quitarDeLaTabla(catalogo, tablaCarrito, lista, actual);
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompraActionPerformed
        try {
            // TODO add your handling code here:
            TicketPDF.crearPdf(tablaCarrito,++numero,cliente);
            ControlCatalogo.limpiarTabla(tablaCarrito);
            enviarRecibir.actualizarPorCompra(lista);
            lista.clear();
            catalogo = enviarRecibir.pedirCatalogo(catalogo);
            jTabbedPane1.setSelectedIndex(1);
        } catch (FileNotFoundException | DocumentException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Error al crar el ticket", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "Error al recibir ticket", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonCompraActionPerformed

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
            java.util.logging.Logger.getLogger(IGCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IGCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IGCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IGCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IGCatalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonCompra;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JLabel etiquetaCantidad;
    private javax.swing.JLabel etiquetaCliente;
    private javax.swing.JLabel etiquetaDatos;
    private javax.swing.JLabel etiquetaDesc;
    private javax.swing.JLabel etiquetaExistencia;
    private javax.swing.JLabel etiquetaId;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPrecio;
    private javax.swing.JLabel etiquetasTallas;
    private javax.swing.JLabel imagen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelCarrito;
    private javax.swing.JPanel panelCatalogo;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JLabel part1;
    private javax.swing.JLabel part2;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JLabel textoDesc;
    private javax.swing.JLabel textoExitencia;
    private javax.swing.JLabel textoId;
    private javax.swing.JLabel textoPrecio;
    // End of variables declaration//GEN-END:variables

}
