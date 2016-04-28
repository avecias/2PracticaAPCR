package Cliente.controlador;

import Cliente.modelo.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControlCatalogo {

    public static void imprimirDatosCliente(Cliente cliente, JLabel etiquetaNombre, JLabel etiquetaDatos) {
        etiquetaNombre.setText("Nombre: " + cliente.getNombre() + " " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno());
        etiquetaDatos.setText("id: " + cliente.getId() + ", Edad: " + cliente.getEdad() + ", Sexo " + cliente.getSexo());
    }

    public static void colocarCatalogo(ArrayList<Zapato> catalogo, Zapato zapaton, JLabel textoId, JLabel textoDesc, JLabel textoPrecio, JLabel textoExitencia, JButton botonAnterior) {
        zapaton = catalogo.get(0);
        textoId.setText(String.valueOf(zapaton.getId()));
        textoDesc.setText(zapaton.getDescripcion());
        textoPrecio.setText(String.valueOf(zapaton.getPrecio()));
        textoExitencia.setText(String.valueOf(zapaton.getExistencia()));
        botonAnterior.setEnabled(false);
    }

    public static void anterior(JButton botonAnterior, JButton botonSiguiente, Zapato zapaton, JLabel textoId, JLabel textoDesc, JLabel textoPrecio, JLabel textoExitencia, int anterior) {
        botonSiguiente.setEnabled(true);
        textoId.setText(String.valueOf(zapaton.getId()));
        textoDesc.setText(zapaton.getDescripcion());
        textoPrecio.setText(String.valueOf(zapaton.getPrecio()));
        textoExitencia.setText(String.valueOf(zapaton.getExistencia()));
        if (anterior == -1) {
            botonAnterior.setEnabled(false);
        }
    }

    public static void siguiente(JButton botonAnterior, JButton botonSiguiente, Zapato zapaton, JLabel textoId, JLabel textoDesc, JLabel textoPrecio, JLabel textoExitencia, int siguiente, int limite) {
        botonAnterior.setEnabled(true);
        textoId.setText(String.valueOf(zapaton.getId()));
        textoDesc.setText(zapaton.getDescripcion());
        textoPrecio.setText(String.valueOf(zapaton.getPrecio()));
        textoExitencia.setText(String.valueOf(zapaton.getExistencia()));
        if (siguiente == limite) {
            botonSiguiente.setEnabled(false);
        }
    }

    public static void agregarALaTabla(ArrayList<Zapato> catalogo, JTable tablaCarrito, Zapato zapaton, ArrayList<Compra> lista, JSpinner cantidad, int actual, JLabel etiquetaExistencias) {
        int comprados = Integer.valueOf(String.valueOf(cantidad.getValue()));
        int existenciaActual = zapaton.getExistencia() - comprados;
        if (existenciaActual <= -1) {
            JOptionPane.showMessageDialog(null, "Articulo no suficiente, seleccione otra vez", "No suficientes", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel tabla = (DefaultTableModel) tablaCarrito.getModel();
            Object[] fila = new Object[5];
            fila[0] = zapaton.getId();
            fila[1] = zapaton.getDescripcion();
            fila[2] = comprados;
            fila[3] = zapaton.getPrecio();
            fila[4] = comprados * zapaton.getPrecio();
            tabla.addRow(fila);
            zapaton.setExistencia(existenciaActual);
            catalogo.set(actual, zapaton);
            lista.add(new Compra(zapaton.getId(), comprados));
            etiquetaExistencias.setText(String.valueOf(existenciaActual));
        }
    }

    public static void quitarDeLaTabla(ArrayList<Zapato> catalogo, JTable tablaCarrito, ArrayList<Compra> lista, int actual) {
        DefaultTableModel tabla = (DefaultTableModel) tablaCarrito.getModel();
        if (tablaCarrito.getSelectedRow() != -1) {
            int id = Integer.valueOf(String.valueOf(tabla.getValueAt(tablaCarrito.getSelectedRow(), 0)));
            Object seleccionado = tabla.getValueAt(tablaCarrito.getSelectedRow(), 2);
            Integer existencia = Integer.valueOf(String.valueOf(seleccionado));
            lista.remove(tablaCarrito.getSelectedRow());
            tabla.removeRow(tablaCarrito.getSelectedRow());
            Zapato zapatoModificado = buscarZapato(catalogo, id);
            zapatoModificado.setExistencia(zapatoModificado.getExistencia() + existencia);
            catalogo.set(buscarIndex(catalogo, id), zapatoModificado);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una columna", "Cliente", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static BufferedImage[] cargarImagenes(ArrayList<Zapato> catalogo, BufferedImage[] imagenes) {
        imagenes = new BufferedImage[catalogo.size()];
        for (int i = 0; i < catalogo.size(); i++) {
            try {
                imagenes[i] = ImageIO.read(new File("imagenesCliente//" + catalogo.get(i).getArchivo()));
            } catch (IOException ex) {
                System.err.println("Error al cargar imagenen " + ex);
            }
        }
        return imagenes;
    }

    private static Zapato buscarZapato(ArrayList<Zapato> catalogo, int id) {
        Zapato zapato = new Zapato();
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getId() == id) {
                zapato = catalogo.get(i);
            }
        }
        return zapato;
    }

    private static int buscarIndex(ArrayList<Zapato> catalogo, int id) {
        int index = 0;
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }

    public static void limpiarTabla(JTable tablaCarrito) {
        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Zapato", "Cantidad", "Precio Unitario", "Precio Total"
                }
        ));
    }

    public static void modificarTabla(JTable tablaCarrito, ArrayList<Zapato> catalogo, ArrayList<Compra> lista) {
        DefaultTableModel tabla = (DefaultTableModel) tablaCarrito.getModel();
        if (tablaCarrito.getSelectedRow() != -1) {
            int cantidadActual = Integer.valueOf(String.valueOf(tabla.getValueAt(tablaCarrito.getSelectedRow(), 2)));
            int id = Integer.valueOf(String.valueOf(tabla.getValueAt(tablaCarrito.getSelectedRow(), 0)));
            SpinnerNumberModel Model = new SpinnerNumberModel(cantidadActual, 1, 10, 1);
            JSpinner spinner1 = new JSpinner(Model);
            int option2 = JOptionPane.showOptionDialog(null, spinner1, "Modificar cantidad", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (option2 == JOptionPane.CANCEL_OPTION) {
                // user hit cancel                          
                JOptionPane.showMessageDialog(null,"Ninguna modificacion ");
            } else if (option2 == JOptionPane.OK_OPTION) {
                // user entered a number
                int cantidadNueva = Integer.valueOf(String.valueOf(spinner1.getValue()));
                cantidadActual = cantidadActual - cantidadNueva;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una columna", "Cliente", JOptionPane.WARNING_MESSAGE);
        }
    }

}
