
package Cliente.vista;

import Cliente.modelo.Cliente;
import Cliente.modelo.SocketEnvioRecibo;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    private SocketEnvioRecibo enviar;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaId = new javax.swing.JLabel();
        etiquetaPassword = new javax.swing.JLabel();
        idTexto = new javax.swing.JTextField();
        botonBorrar = new javax.swing.JButton();
        botonEntrar = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        imagen = new javax.swing.JLabel();
        etiquetaDireccion = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido");
        setResizable(false);

        etiquetaTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiquetaTitulo.setText("Bienvenido, inserte id y password");

        etiquetaId.setText("Id:");

        etiquetaPassword.setText("Password:");

        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonEntrar.setText("Entrar");
        botonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrarActionPerformed(evt);
            }
        });

        etiquetaDireccion.setText("Direccion:");

        textoDireccion.setText("localhost");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(imagen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaPassword)
                                    .addComponent(etiquetaId)
                                    .addComponent(etiquetaDireccion))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(botonBorrar)
                                        .addGap(42, 42, 42)
                                        .addComponent(botonEntrar))
                                    .addComponent(idTexto)
                                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(textoDireccion)))
                            .addComponent(etiquetaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(imagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaId)
                    .addComponent(idTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPassword)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDireccion)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBorrar)
                    .addComponent(botonEntrar))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // Borra los campos de texto
        idTexto.setText("");
        password.setText("");
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrarActionPerformed
        // Envair datos al servidor
        String id = idTexto.getText();
        String pass = password.getText();
        if(id.equals("") || pass.equals("")){
            JOptionPane.showMessageDialog(null,"Algun campo esta vacio", "Faltan datos",JOptionPane.ERROR_MESSAGE);
        }
        else{
            enviar = new SocketEnvioRecibo(textoDireccion.getText(),3060);
            Cliente clienteEncontrado = enviar.datosLogin(Integer.valueOf(id), pass);
            if(clienteEncontrado == null || clienteEncontrado.getNombre().equals("")){
                JOptionPane.showMessageDialog(null,"Intente de nuevo", "Cliente no encontrado",JOptionPane.ERROR_MESSAGE);
            }
            else{
                IGCatalogo catalogo = new IGCatalogo();
                catalogo.setVisible(true);
                catalogo.setCliente(clienteEncontrado);
                catalogo.setEnviarRecibir(enviar);
                this.setVisible(false);
                this.dispose();
            }
        }
    }//GEN-LAST:event_botonEntrarActionPerformed

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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonEntrar;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaId;
    private javax.swing.JLabel etiquetaPassword;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JTextField idTexto;
    private javax.swing.JLabel imagen;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField textoDireccion;
    // End of variables declaration//GEN-END:variables
}
