
package Servidor.controlador;

import Servidor.modelo.ResultadoCliente;
import Servidor.modelo.ResultadoZapato;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

public class ControlServidor {

    public static void llenarTablaCliente(Conexion conexion, JTable tablaCliente) {
        DefaultTableModel tabla = (DefaultTableModel) tablaCliente.getModel();
        ArrayList<ResultadoCliente> clientes = new ArrayList<>();
        clientes = conexion.selectCliente(clientes);
        tabla.setNumRows(clientes.size());
        for (int i = 0; i < clientes.size(); i++) {
            ResultadoCliente cliente = clientes.get(i);
            tabla.setValueAt(cliente.getId(), i, 0);
            tabla.setValueAt(cliente.getNombre(), i, 1);
            tabla.setValueAt(cliente.getApellidoPaterno(), i, 2);
            tabla.setValueAt(cliente.getApellidoMaterno(), i, 3);
            tabla.setValueAt(cliente.getSexo(), i, 4);
            tabla.setValueAt(cliente.getPassword(), i, 5);
            tabla.setValueAt(cliente.getEdad(), i, 6);
        }
    }

    public static void llenarTablaZapato(Conexion conexion, JTable tablaZapato) {
        DefaultTableModel tabla = (DefaultTableModel) tablaZapato.getModel();
        ArrayList<ResultadoZapato> zapatos = new ArrayList<>();
        zapatos = conexion.selectZapato(zapatos);
        tabla.setNumRows(zapatos.size());
        for (int i = 0; i < zapatos.size(); i++) {
            ResultadoZapato zapato = zapatos.get(i);
            tabla.setValueAt(zapato.getId(), i, 0);
            tabla.setValueAt(zapato.getPrecio(), i, 1);
            tabla.setValueAt(zapato.getExistencia(), i, 2);
            tabla.setValueAt(zapato.getDescripcion(), i, 3);
            tabla.setValueAt(zapato.getArchivo(), i, 4);
        }
    }

    public static void insertarCliente(Conexion conexion, JTextField textoNombre, JTextField textoPaterno, JTextField textoMaterno, JComboBox comboSexo, JPasswordField password, JSpinner spinnerEdad) {
        String nombre = textoNombre.getText();
        String paterno = textoPaterno.getText();
        String materno = textoMaterno.getText();
        String sexo = String.valueOf(comboSexo.getSelectedItem());
        String pass = password.getText();
        int edad = Integer.valueOf(String.valueOf(spinnerEdad.getValue()));
        ResultadoCliente cliente = new ResultadoCliente(nombre, paterno, materno, sexo, pass, 0, edad);
        System.out.println(cliente.toString());
        if(conexion.insertarCliente(cliente)){
            JOptionPane.showMessageDialog(null,"Cliente agregado con exito");
        }
        else JOptionPane.showMessageDialog(null,"Error al insertar al cliente");
    }

    public static void borrarCliente(Conexion conexion, JTable tablaCliente) {
        if(tablaCliente.getSelectedRow() != -1){
            if(conexion.borrarCliente(tablaCliente.getSelectedRow())){
                JOptionPane.showMessageDialog(null, "Cliente borrado con exito");
            }
            else JOptionPane.showMessageDialog(null, "Error al borrar cliente");
        }
        else JOptionPane.showMessageDialog(null, "Selecione un elemento de la tabla");
    }

    public static int llenarCamposCliente(JTable tablaCliente, JTextField textoNombre, JTextField textoPaterno, JTextField textoMaterno, JComboBox comboSexo, JPasswordField password, JSpinner spinnerEdad) {
        int numero = tablaCliente.getSelectedRow();
        textoNombre.setText(String.valueOf(tablaCliente.getValueAt(numero, 1)));
        textoPaterno.setText(String.valueOf(tablaCliente.getValueAt(numero, 2)));
        textoMaterno.setText(String.valueOf(tablaCliente.getValueAt(numero, 3)));
        String sexo = String.valueOf(tablaCliente.getValueAt(numero, 4));
        if(sexo.equals("F")){
            comboSexo.setSelectedIndex(0);
        }
        else comboSexo.setSelectedIndex(1);
        password.setText(String.valueOf(tablaCliente.getValueAt(numero, 5)));
        spinnerEdad.setValue(tablaCliente.getValueAt(numero, 6));
        return Integer.valueOf(String.valueOf(tablaCliente.getValueAt(numero, 0)));
    }

    public static void modificarCliente(Conexion conexion, int idUpdate, JTextField textoNombre, JTextField textoPaterno, JTextField textoMaterno, JComboBox comboSexo, JPasswordField password, JSpinner spinnerEdad) {
        String nombre = textoNombre.getText();
        String paterno = textoPaterno.getText();
        String materno = textoMaterno.getText();
        String sexo = String.valueOf(comboSexo.getSelectedItem());
        String pass = password.getText();
        int edad = Integer.valueOf(String.valueOf(spinnerEdad.getValue()));
        ResultadoCliente cliente = new ResultadoCliente(nombre, paterno, materno, sexo, pass, idUpdate, edad);
        if(conexion.modificarCliente(cliente,idUpdate)){
            JOptionPane.showMessageDialog(null,"Cliente modificado con exito");
        }
        else JOptionPane.showMessageDialog(null,"Error al modificar al cliente");
    }

    public static void insertarZapato(Conexion conexion, JTextField textoDescripcion, JSpinner spinnerExistencia, JSpinner spinnerPrecio, JTextField textoImagen) {
        String descripcion = textoDescripcion.getText();
        String nombreImagen = textoImagen.getText();
        int exitencia = Integer.valueOf(String.valueOf(spinnerExistencia.getValue()));
        int precio = Integer.valueOf(String.valueOf(spinnerPrecio.getValue()));
        ResultadoZapato zapato = new ResultadoZapato(0, precio, exitencia, descripcion, nombreImagen);
        if(conexion.insertarZapato(zapato)){
            JOptionPane.showMessageDialog(null,"Zapato agregado con exito");
        }
        else JOptionPane.showMessageDialog(null,"Error al insertar al zapato");
    }

    public static String cargarImagen(BufferedImage imagen) {
        JFileChooser elegir = new JFileChooser();
        elegir.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        elegir.setFileFilter(filtroImagen);
        if(elegir.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            try {
                imagen = ImageIO.read(elegir.getSelectedFile());
                ImageIO.write(imagen, "JPG",new File("imagenesServidor//" + elegir.getSelectedFile().getName()));
                return elegir.getName(elegir.getSelectedFile());
            } catch (IOException ex) {
                System.err.println(ex);
                return "";
            }
        }
        else return "";
    }

    public static int llenarCamposZapato(JTable tablaZapato, JTextField textoDescripcion, JSpinner spinnerExistencia, JSpinner spinnerPrecio) {
        int numero = tablaZapato.getSelectedRow();
        textoDescripcion.setText(String.valueOf(tablaZapato.getValueAt(numero, 3)));
        spinnerExistencia.setValue(tablaZapato.getValueAt(numero, 2));
        spinnerPrecio.setValue(tablaZapato.getValueAt(numero, 1));
        return Integer.valueOf(String.valueOf(tablaZapato.getValueAt(numero, 0)));
    }

    public static void borrarZapato(Conexion conexion, JTable tablaZapato) {
        if(tablaZapato.getSelectedRow() != -1){
            if(conexion.borrarZapato(tablaZapato.getSelectedRow())){
                JOptionPane.showMessageDialog(null, "Zapato borrado con exito de la tabla");
            }
            else JOptionPane.showMessageDialog(null, "Error al borrar el zapato de la tabla");
        }
        else JOptionPane.showMessageDialog(null, "Selecione un elemento de la tabla");
    }

    public static void modificarZapato(Conexion conexion, int idUpdate, JTextField textoDescripcion, JSpinner spinnerPrecio, JSpinner spinnerExistencia) {
        String descripcion = textoDescripcion.getText();
        int existencia = Integer.valueOf(String.valueOf(spinnerExistencia.getValue()));
        int precio = Integer.valueOf(String.valueOf(spinnerPrecio.getValue()));
        ResultadoZapato zapato = new ResultadoZapato(idUpdate,precio,existencia,descripcion);
        if(conexion.modificarZapato(zapato,idUpdate)){
            JOptionPane.showMessageDialog(null,"Zapato modificado con exito");
        }
        else JOptionPane.showMessageDialog(null,"Error al modificar zapato");
    }

}
