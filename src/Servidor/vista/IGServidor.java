
package Servidor.vista;

import Servidor.controlador.ControlServidor;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import modelo.Conexion;
import Servidor.modelo.HiloServidor;

public class IGServidor extends javax.swing.JFrame {

    private Conexion conexion;
    private int idUpdate;
    private BufferedImage imagen;
    private Thread hilo;
    private HiloServidor servidor;
    
    public IGServidor() {
        initComponents();
        conexion = new Conexion();
        ControlServidor.llenarTablaCliente(conexion,tablaCliente);
        ControlServidor.llenarTablaZapato(conexion,tablaZapato);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneles = new javax.swing.JTabbedPane();
        panelInicio = new javax.swing.JPanel();
        imagenServidor = new javax.swing.JLabel();
        etiquetaEstado = new javax.swing.JLabel();
        botonIniciar = new javax.swing.JButton();
        botonParar = new javax.swing.JButton();
        etiquetaPuerto = new javax.swing.JLabel();
        textoPuerto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaNotificacion = new javax.swing.JTextArea();
        panelCliente = new javax.swing.JPanel();
        etiquetaCliente = new javax.swing.JLabel();
        botonAgregarCliente = new javax.swing.JButton();
        panelDatosCliente = new javax.swing.JPanel();
        botonCancelarCliente = new javax.swing.JButton();
        botonModificarClienteConfirmacion = new javax.swing.JButton();
        etiquetaNombre = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoPaterno = new javax.swing.JTextField();
        textoMaterno = new javax.swing.JTextField();
        comboSexo = new javax.swing.JComboBox();
        etiquetSexo = new javax.swing.JLabel();
        etiquetEdad = new javax.swing.JLabel();
        etiquetaPassword = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        botonAgregarClienteConfirmacion = new javax.swing.JButton();
        spinnerEdad = new javax.swing.JSpinner();
        botonBorrarCliente = new javax.swing.JButton();
        botonModificarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        panelCatalogo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaZapato = new javax.swing.JTable();
        etiquetaZapato = new javax.swing.JLabel();
        botonAgregarZapato = new javax.swing.JButton();
        botonBorrarZapato = new javax.swing.JButton();
        botonModificarZapato = new javax.swing.JButton();
        panelDatosZapato = new javax.swing.JPanel();
        etiquetaDescripcion = new javax.swing.JLabel();
        textoDescripcion = new javax.swing.JTextField();
        etiquetaExistencia = new javax.swing.JLabel();
        spinnerExistencia = new javax.swing.JSpinner();
        etiquetaPrecio = new javax.swing.JLabel();
        botonModificarZapatoConfirmacion = new javax.swing.JButton();
        botonAgregarZapatoConfirmacion = new javax.swing.JButton();
        botonCancelarZapato = new javax.swing.JButton();
        spinnerPrecio = new javax.swing.JSpinner();
        etiquetaImagen = new javax.swing.JLabel();
        botonImagen = new javax.swing.JButton();
        textoImagen = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuActualizar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");

        imagenServidor.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hyper\\Documents\\NetBeansProjects\\2PracticaAPCR\\imagenes\\server.png")); // NOI18N

        etiquetaEstado.setText("Iniciar el servidor");

        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });

        botonParar.setText("Parar");
        botonParar.setEnabled(false);
        botonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPararActionPerformed(evt);
            }
        });

        etiquetaPuerto.setText("Puerto");

        textoPuerto.setText("3060");

        areaNotificacion.setColumns(20);
        areaNotificacion.setRows(5);
        jScrollPane3.setViewportView(areaNotificacion);

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(imagenServidor)
                .addGap(18, 18, 18)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addComponent(botonIniciar)
                                .addGap(18, 18, 18)
                                .addComponent(botonParar))
                            .addComponent(etiquetaEstado))
                        .addGap(42, 42, 42)
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaPuerto)
                            .addComponent(textoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaEstado)
                    .addComponent(etiquetaPuerto))
                .addGap(11, 11, 11)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenServidor)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonIniciar)
                            .addComponent(botonParar)
                            .addComponent(textoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                .addContainerGap())
        );

        paneles.addTab("Inicio", panelInicio);

        etiquetaCliente.setText("Modificar catalogo de la tabla cliente");

        botonAgregarCliente.setText("Agregar");
        botonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarClienteActionPerformed(evt);
            }
        });

        panelDatosCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonCancelarCliente.setText("Cancelar");
        botonCancelarCliente.setEnabled(false);
        botonCancelarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarClienteActionPerformed(evt);
            }
        });

        botonModificarClienteConfirmacion.setText("Modificar");
        botonModificarClienteConfirmacion.setEnabled(false);
        botonModificarClienteConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarClienteConfirmacionActionPerformed(evt);
            }
        });

        etiquetaNombre.setText("Nombre completo");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));

        etiquetSexo.setText("Sexo");

        etiquetEdad.setText("Edad");

        etiquetaPassword.setText("Password");

        botonAgregarClienteConfirmacion.setText("Agregar");
        botonAgregarClienteConfirmacion.setEnabled(false);
        botonAgregarClienteConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarClienteConfirmacionActionPerformed(evt);
            }
        });

        spinnerEdad.setModel(new javax.swing.SpinnerNumberModel(15, 10, 99, 1));

        javax.swing.GroupLayout panelDatosClienteLayout = new javax.swing.GroupLayout(panelDatosCliente);
        panelDatosCliente.setLayout(panelDatosClienteLayout);
        panelDatosClienteLayout.setHorizontalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaNombre)
                    .addComponent(etiquetSexo)
                    .addComponent(etiquetaPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(botonAgregarClienteConfirmacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonModificarClienteConfirmacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCancelarCliente))
                    .addGroup(panelDatosClienteLayout.createSequentialGroup()
                        .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosClienteLayout.createSequentialGroup()
                                .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(etiquetEdad)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(textoNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDatosClienteLayout.setVerticalGroup(
            panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetSexo)
                    .addComponent(etiquetEdad)
                    .addComponent(spinnerEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCancelarCliente)
                        .addComponent(botonModificarClienteConfirmacion)
                        .addComponent(botonAgregarClienteConfirmacion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiquetaPassword)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        botonBorrarCliente.setText("Borrar");
        botonBorrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarClienteActionPerformed(evt);
            }
        });

        botonModificarCliente.setText("Modificar");
        botonModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarClienteActionPerformed(evt);
            }
        });

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Paterno", "Materno", "Sexo", "Password", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaCliente);
        if (tablaCliente.getColumnModel().getColumnCount() > 0) {
            tablaCliente.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaCliente.getColumnModel().getColumn(4).setPreferredWidth(30);
            tablaCliente.getColumnModel().getColumn(6).setPreferredWidth(30);
        }

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(etiquetaCliente)
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonModificarCliente)
                            .addComponent(botonAgregarCliente)
                            .addComponent(botonBorrarCliente))
                        .addGap(18, 18, 18)
                        .addComponent(panelDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addComponent(botonAgregarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBorrarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonModificarCliente))
                    .addComponent(panelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneles.addTab("Modificar Cliente", panelCliente);

        tablaZapato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Precio", "Existencias", "Descripcion", "Archivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaZapato);
        if (tablaZapato.getColumnModel().getColumnCount() > 0) {
            tablaZapato.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaZapato.getColumnModel().getColumn(1).setPreferredWidth(50);
            tablaZapato.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        etiquetaZapato.setText("Modificar catalogo de la tabla zapato");

        botonAgregarZapato.setText("Agregar");
        botonAgregarZapato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarZapatoActionPerformed(evt);
            }
        });

        botonBorrarZapato.setText("Borrar");
        botonBorrarZapato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarZapatoActionPerformed(evt);
            }
        });

        botonModificarZapato.setText("Modificar");
        botonModificarZapato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarZapatoActionPerformed(evt);
            }
        });

        panelDatosZapato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        etiquetaDescripcion.setText("Descripcion");

        etiquetaExistencia.setText("Existencia");

        spinnerExistencia.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        etiquetaPrecio.setText("Precio");

        botonModificarZapatoConfirmacion.setText("Modificar");
        botonModificarZapatoConfirmacion.setEnabled(false);
        botonModificarZapatoConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarZapatoConfirmacionActionPerformed(evt);
            }
        });

        botonAgregarZapatoConfirmacion.setText("Agregar");
        botonAgregarZapatoConfirmacion.setEnabled(false);
        botonAgregarZapatoConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarZapatoConfirmacionActionPerformed(evt);
            }
        });

        botonCancelarZapato.setText("Cancelar");
        botonCancelarZapato.setEnabled(false);
        botonCancelarZapato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarZapatoActionPerformed(evt);
            }
        });

        spinnerPrecio.setModel(new javax.swing.SpinnerNumberModel(100, 100, 10000, 100));

        etiquetaImagen.setText("Seleccione Imagen");

        botonImagen.setText("Imagen...");
        botonImagen.setEnabled(false);
        botonImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImagenActionPerformed(evt);
            }
        });

        textoImagen.setEnabled(false);

        javax.swing.GroupLayout panelDatosZapatoLayout = new javax.swing.GroupLayout(panelDatosZapato);
        panelDatosZapato.setLayout(panelDatosZapatoLayout);
        panelDatosZapatoLayout.setHorizontalGroup(
            panelDatosZapatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosZapatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosZapatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaDescripcion)
                    .addComponent(etiquetaExistencia)
                    .addComponent(etiquetaPrecio))
                .addGap(18, 18, 18)
                .addGroup(panelDatosZapatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosZapatoLayout.createSequentialGroup()
                        .addComponent(spinnerExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(etiquetaImagen)
                        .addGap(31, 31, 31)
                        .addComponent(botonImagen)
                        .addGap(18, 18, 18)
                        .addComponent(textoImagen))
                    .addGroup(panelDatosZapatoLayout.createSequentialGroup()
                        .addGroup(panelDatosZapatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosZapatoLayout.createSequentialGroup()
                                .addComponent(spinnerPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(botonModificarZapatoConfirmacion)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregarZapatoConfirmacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonCancelarZapato))
                            .addComponent(textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDatosZapatoLayout.setVerticalGroup(
            panelDatosZapatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosZapatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosZapatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDescripcion)
                    .addComponent(textoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosZapatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaExistencia)
                    .addComponent(spinnerExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaImagen)
                    .addComponent(botonImagen)
                    .addComponent(textoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosZapatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPrecio)
                    .addComponent(botonModificarZapatoConfirmacion)
                    .addComponent(botonAgregarZapatoConfirmacion)
                    .addComponent(botonCancelarZapato)
                    .addComponent(spinnerPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelCatalogoLayout = new javax.swing.GroupLayout(panelCatalogo);
        panelCatalogo.setLayout(panelCatalogoLayout);
        panelCatalogoLayout.setHorizontalGroup(
            panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCatalogoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(etiquetaZapato)
                    .addGroup(panelCatalogoLayout.createSequentialGroup()
                        .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonModificarZapato)
                            .addComponent(botonAgregarZapato)
                            .addComponent(botonBorrarZapato))
                        .addGap(18, 18, 18)
                        .addComponent(panelDatosZapato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCatalogoLayout.setVerticalGroup(
            panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCatalogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaZapato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCatalogoLayout.createSequentialGroup()
                        .addComponent(botonAgregarZapato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBorrarZapato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonModificarZapato))
                    .addComponent(panelDatosZapato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneles.addTab("Modificar Catalogo", panelCatalogo);

        jMenu1.setText("File");

        menuActualizar.setText("Actualizar");
        menuActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActualizarActionPerformed(evt);
            }
        });
        jMenu1.add(menuActualizar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneles)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneles)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarClienteActionPerformed
        // TODO add your handling code here:
        if(tablaCliente.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null,"Seleccione un cliente");
            return;
        }
        botonAgregarCliente.setEnabled(false);
        botonBorrarCliente.setEnabled(false);
        botonModificarCliente.setEnabled(false);
        botonModificarClienteConfirmacion.setEnabled(true);
        botonCancelarCliente.setEnabled(true);
        idUpdate = ControlServidor.llenarCamposCliente(tablaCliente,textoNombre,textoPaterno,textoMaterno,comboSexo,password,spinnerEdad);
    }//GEN-LAST:event_botonModificarClienteActionPerformed

    private void botonAgregarZapatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarZapatoActionPerformed
        // TODO add your handling code here:
        botonAgregarZapato.setEnabled(false);
        botonBorrarZapato.setEnabled(false);
        botonModificarZapato.setEnabled(false);
        botonAgregarZapatoConfirmacion.setEnabled(true);
        botonCancelarZapato.setEnabled(true);
        botonImagen.setEnabled(true);
    }//GEN-LAST:event_botonAgregarZapatoActionPerformed

    private void botonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarClienteActionPerformed
        // TODO add your handling code here:
        botonAgregarCliente.setEnabled(false);
        botonBorrarCliente.setEnabled(false);
        botonModificarCliente.setEnabled(false);
        botonAgregarClienteConfirmacion.setEnabled(true);
        botonCancelarCliente.setEnabled(true);
    }//GEN-LAST:event_botonAgregarClienteActionPerformed

    private void botonAgregarClienteConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarClienteConfirmacionActionPerformed
        // TODO add your handling code here:
        if(validarCamposCliente()){
            JOptionPane.showMessageDialog(null,"Faltan campos");
            return;
        }
        ControlServidor.insertarCliente(conexion,textoNombre,textoPaterno,textoMaterno,comboSexo,password,spinnerEdad);
        botonAgregarCliente.setEnabled(true);
        botonBorrarCliente.setEnabled(true);
        botonModificarCliente.setEnabled(true);
        botonAgregarClienteConfirmacion.setEnabled(false);
        botonCancelarCliente.setEnabled(false);
        borrarTextoCliente();
        ControlServidor.llenarTablaCliente(conexion, tablaCliente);
    }//GEN-LAST:event_botonAgregarClienteConfirmacionActionPerformed

    private void botonCancelarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarClienteActionPerformed
        // TODO add your handling code here:
        botonAgregarCliente.setEnabled(true);
        botonBorrarCliente.setEnabled(true);
        botonModificarCliente.setEnabled(true);
        botonAgregarClienteConfirmacion.setEnabled(false);
        botonCancelarCliente.setEnabled(false);
        botonModificarClienteConfirmacion.setEnabled(false);
        borrarTextoCliente();
    }//GEN-LAST:event_botonCancelarClienteActionPerformed

    private void botonBorrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarClienteActionPerformed
        // TODO add your handling code here:
        ControlServidor.borrarCliente(conexion,tablaCliente);
        ControlServidor.llenarTablaCliente(conexion, tablaCliente);
    }//GEN-LAST:event_botonBorrarClienteActionPerformed

    private void botonModificarClienteConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarClienteConfirmacionActionPerformed
        // TODO add your handling code here:
        if(validarCamposCliente()){
            JOptionPane.showMessageDialog(null,"Faltan campos");
            return;
        }
        ControlServidor.modificarCliente(conexion,idUpdate,textoNombre,textoPaterno,textoMaterno,comboSexo,password,spinnerEdad);
        botonAgregarCliente.setEnabled(true);
        botonBorrarCliente.setEnabled(true);
        botonModificarCliente.setEnabled(true);
        botonModificarClienteConfirmacion.setEnabled(false);
        botonCancelarCliente.setEnabled(false);
        borrarTextoCliente();
        ControlServidor.llenarTablaCliente(conexion, tablaCliente);
    }//GEN-LAST:event_botonModificarClienteConfirmacionActionPerformed

    private void botonAgregarZapatoConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarZapatoConfirmacionActionPerformed
        // TODO add your handling code here:
        if(textoDescripcion.getText().equals("") || textoImagen.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Faltan campos o imagen");
            return;
        }
        ControlServidor.insertarZapato(conexion,textoDescripcion,spinnerExistencia,spinnerPrecio,textoImagen);
        ControlServidor.llenarTablaZapato(conexion, tablaZapato);
        botonAgregarZapato.setEnabled(true);
        botonBorrarZapato.setEnabled(true);
        botonModificarZapato.setEnabled(true);
        botonAgregarZapatoConfirmacion.setEnabled(false);
        botonCancelarZapato.setEnabled(false);
        textoDescripcion.setText("");
        botonImagen.setEnabled(false);
        ControlServidor.llenarTablaZapato(conexion, tablaZapato);
    }//GEN-LAST:event_botonAgregarZapatoConfirmacionActionPerformed

    private void botonCancelarZapatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarZapatoActionPerformed
        // TODO add your handling code here:
        botonAgregarZapato.setEnabled(true);
        botonBorrarZapato.setEnabled(true);
        botonModificarZapato.setEnabled(true);
        textoDescripcion.setText("");
        botonImagen.setEnabled(false);
        botonAgregarZapatoConfirmacion.setEnabled(false);
        botonCancelarZapato.setEnabled(false);
        botonModificarZapatoConfirmacion.setEnabled(false);
    }//GEN-LAST:event_botonCancelarZapatoActionPerformed

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
        // TODO add your handling code here:
        servidor = new HiloServidor(false,conexion,Integer.valueOf(textoPuerto.getText()),areaNotificacion);
        hilo = new Thread(servidor);
        hilo.start();
        botonParar.setEnabled(true);
        botonIniciar.setEnabled(false);
    }//GEN-LAST:event_botonIniciarActionPerformed

    private void botonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPararActionPerformed
        // TODO add your handling code here:
        servidor.cerrarServidor(true);
        botonIniciar.setEnabled(true);
        botonParar.setEnabled(false);
    }//GEN-LAST:event_botonPararActionPerformed

    private void botonImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImagenActionPerformed
        // TODO add your handling code here:
        textoImagen.setText(ControlServidor.cargarImagen(imagen));
    }//GEN-LAST:event_botonImagenActionPerformed

    private void botonModificarZapatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarZapatoActionPerformed
        // TODO add your handling code here:
        if(tablaZapato.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null,"Seleccione un zapato");
            return;
        }
        botonAgregarZapato.setEnabled(false);
        botonBorrarZapato.setEnabled(false);
        botonModificarZapato.setEnabled(false);
        botonModificarZapatoConfirmacion.setEnabled(true);
        botonCancelarZapato.setEnabled(true);
        idUpdate = ControlServidor.llenarCamposZapato(tablaZapato,textoDescripcion,spinnerExistencia,spinnerPrecio);
    }//GEN-LAST:event_botonModificarZapatoActionPerformed

    private void botonBorrarZapatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarZapatoActionPerformed
        // TODO add your handling code here:
        ControlServidor.borrarZapato(conexion,tablaZapato);
        ControlServidor.llenarTablaZapato(conexion, tablaZapato);
    }//GEN-LAST:event_botonBorrarZapatoActionPerformed

    private void botonModificarZapatoConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarZapatoConfirmacionActionPerformed
        // TODO add your handling code here:
        if(textoDescripcion.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Faltan campos");
            return;
        }
        ControlServidor.modificarZapato(conexion,idUpdate,textoDescripcion,spinnerPrecio,spinnerExistencia);
        botonAgregarZapato.setEnabled(true);
        botonBorrarZapato.setEnabled(true);
        botonModificarZapato.setEnabled(true);
        botonModificarZapatoConfirmacion.setEnabled(false);
        botonCancelarZapato.setEnabled(false);
        textoDescripcion.setText("");
        ControlServidor.llenarTablaZapato(conexion, tablaZapato);
    }//GEN-LAST:event_botonModificarZapatoConfirmacionActionPerformed

    private void menuActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActualizarActionPerformed
        // TODO add your handling code here:
        ControlServidor.llenarTablaCliente(conexion,tablaCliente);
        ControlServidor.llenarTablaZapato(conexion,tablaZapato);
    }//GEN-LAST:event_menuActualizarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(IGServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IGServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IGServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IGServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IGServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaNotificacion;
    private javax.swing.JButton botonAgregarCliente;
    private javax.swing.JButton botonAgregarClienteConfirmacion;
    private javax.swing.JButton botonAgregarZapato;
    private javax.swing.JButton botonAgregarZapatoConfirmacion;
    private javax.swing.JButton botonBorrarCliente;
    private javax.swing.JButton botonBorrarZapato;
    private javax.swing.JButton botonCancelarCliente;
    private javax.swing.JButton botonCancelarZapato;
    private javax.swing.JButton botonImagen;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonModificarCliente;
    private javax.swing.JButton botonModificarClienteConfirmacion;
    private javax.swing.JButton botonModificarZapato;
    private javax.swing.JButton botonModificarZapatoConfirmacion;
    private javax.swing.JButton botonParar;
    private javax.swing.JComboBox comboSexo;
    private javax.swing.JLabel etiquetEdad;
    private javax.swing.JLabel etiquetSexo;
    private javax.swing.JLabel etiquetaCliente;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaExistencia;
    private javax.swing.JLabel etiquetaImagen;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPassword;
    private javax.swing.JLabel etiquetaPrecio;
    private javax.swing.JLabel etiquetaPuerto;
    private javax.swing.JLabel etiquetaZapato;
    private javax.swing.JLabel imagenServidor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem menuActualizar;
    private javax.swing.JPanel panelCatalogo;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelDatosCliente;
    private javax.swing.JPanel panelDatosZapato;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JTabbedPane paneles;
    private javax.swing.JPasswordField password;
    private javax.swing.JSpinner spinnerEdad;
    private javax.swing.JSpinner spinnerExistencia;
    private javax.swing.JSpinner spinnerPrecio;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTable tablaZapato;
    private javax.swing.JTextField textoDescripcion;
    private javax.swing.JTextField textoImagen;
    private javax.swing.JTextField textoMaterno;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPaterno;
    private javax.swing.JTextField textoPuerto;
    // End of variables declaration//GEN-END:variables

    private boolean validarCamposCliente() {
        return textoNombre.getText().equals("") || textoPaterno.getText().equals("") || textoMaterno.getText().equals("") ||password.getText().equals("");
    }

    private void borrarTextoCliente() {
        textoNombre.setText("");
        textoPaterno.setText("");
        textoMaterno.setText("");
        password.setText("");
    }
}
