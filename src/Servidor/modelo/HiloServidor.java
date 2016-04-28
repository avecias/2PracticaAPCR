package Servidor.modelo;

import Cliente.modelo.*;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextArea;
import modelo.Conexion;

public class HiloServidor implements Runnable {

    private boolean bandera;
    private modelo.Conexion conexion;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private ServerSocket serverSocket;
    private Socket socket,socketFoto;
    private boolean session;
    private ArrayList<Zapato> catalogo;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;
    private byte[] byteArray;
    private int in;
    private JTextArea areaNotificacion;

    public HiloServidor(boolean bandera, Conexion conexion, int puerto, JTextArea areaNotificacion) {
        try {
            this.conexion = conexion;
            this.areaNotificacion = areaNotificacion;
            serverSocket = new ServerSocket(puerto);
            session = true;
            this.bandera = bandera;
            catalogo = new ArrayList<>();
        } catch (IOException ex) {
            areaNotificacion.append("\nError al iniciar el hilo " + ex);
        }
    }

    @Override
    public void run() {
        areaNotificacion.append("Servidor iniciado...");
        while (true) {
            try {
                iniciar();
                if (bandera) {
                    areaNotificacion.append("\nHilo Servidor terminado");
                    break;
                }
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                areaNotificacion.append("\nError al iniciar servidor " + ex);
            }
        }
        try {
            serverSocket.close();
        } catch (IOException ex) {
            areaNotificacion.append("\nError al cerrar el socket " + ex);
        }
    }

    public void iniciar() throws IOException, ClassNotFoundException, SQLException {
        session = true;
        Cliente cliente = recibirCliente();
        if (!cliente.getNombre().equals("")) {
            while (session) {
                areaNotificacion.append("\nEsperando peticion del cliente: " + cliente.getNombre());
                peticion();
            }
        } else {
            areaNotificacion.append("\nNo cliente");
        }
    }

    private Cliente recibirCliente() {
        try {
            areaNotificacion.append("\nEsperando cliente, en el puerto:  " + serverSocket.getLocalPort() + "...");
            socket = serverSocket.accept();
            areaNotificacion.append("\nAceptado");
            entrada = new ObjectInputStream(socket.getInputStream());
            areaNotificacion.append("\nIp del cliente " + socket.getInetAddress().toString());
            Cliente cliente = (Cliente) entrada.readObject();
            areaNotificacion.append("\nDatos recibidos: Id " + cliente.getId() + ", password: " + cliente.getPassword());
            //Buscar al cliente
            Cliente clienteEncontrado = conexion.buscarCliente(cliente,areaNotificacion);
            //Mandar al cliente resultado
            salida = new ObjectOutputStream(socket.getOutputStream());
            salida.writeObject(clienteEncontrado);
            socket.close();
            entrada.close();
            salida.close();
            return clienteEncontrado;
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            areaNotificacion.append("\nError al buscar el cliente " + ex);
            return null;
        }
    }

    private void peticion() {
        try {
            socket = serverSocket.accept();
            entrada = new ObjectInputStream(socket.getInputStream());
            
            Object objecto = entrada.readObject();
            if (objecto instanceof Boolean) {
                //Cerrar el ciclo
                areaNotificacion.append("\nPeticion de cerrar la session ");
                session = (Boolean) objecto;
            } else if (objecto instanceof ArrayList) {
                //mandar catalogo
                areaNotificacion.append("\nLista recibida ");
                ArrayList lista = (ArrayList) objecto;
                if (lista.get(0) instanceof Zapato) {
                    areaNotificacion.append("\nPeticion de enviar catalogo ");
                    catalogo = conexion.llenarCatalogo((ArrayList<Zapato>) objecto);
                    areaNotificacion.append("\nNumero de elemento en el catalogo enviado " + catalogo.size());
                    salida = new ObjectOutputStream(socket.getOutputStream());
                    salida.writeObject(catalogo);
                    enviarFotos(catalogo,socket.getInetAddress());
                } else {
                    areaNotificacion.append("\nPeticion de actualizar por compra ");
                    conexion.actualizarPorCompra((ArrayList<Compra>) objecto);
                }

            } else {
                //Otra nueva peticion
                areaNotificacion.append("\nPeticion vacia");
            }
            salida.close();
            entrada.close();
            socket.close();
        } catch (IOException | ClassNotFoundException ex) {
            areaNotificacion.append("\nError en la peticion " + ex);
        }
    }

    public void cerrarServidor(boolean bandera) {
        try {
            this.bandera = bandera;
            if(socket != null)
                socket.close();
            serverSocket.close();
            session = false;
        } catch (IOException ex) {
            areaNotificacion.append("\nError al cerrar el server socket " + ex);
        }
    }

    private void enviarFotos(ArrayList<Zapato> catalogo, InetAddress direccion) {
        try {
            for (int i = 0; i < catalogo.size(); i++) {
                socketFoto = new Socket(direccion, 9090);
                bis = new BufferedInputStream(new FileInputStream("imagenesServidor/" + catalogo.get(i).getArchivo()));
                bos = new BufferedOutputStream(socketFoto.getOutputStream());
                byteArray = new byte[1024];
                while ((in = bis.read(byteArray)) != -1) {
                    bos.write(byteArray, 0, in);
                }
                areaNotificacion.append("\nImagen enviada " + catalogo.get(i).getArchivo());
                bis.close();
                bos.close();
                socketFoto.close();
            }
        } catch (IOException ex) {
            areaNotificacion.append("\nError al enviar " + ex);
        }
    }

}
