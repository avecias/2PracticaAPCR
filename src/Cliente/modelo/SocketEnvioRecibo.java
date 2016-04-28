package Cliente.modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
//import java.util.Scanner;
import javax.swing.JOptionPane;

public class SocketEnvioRecibo {

    private Socket socket, socketFoto;
    private ServerSocket server;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private int puerto;
    private String ip;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;
    private byte[] receivedData;
    private int in;

    public SocketEnvioRecibo(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }

    public Cliente datosLogin(int id, String password) {
        try {
            socket = new Socket(ip, puerto);
            salida = new ObjectOutputStream(socket.getOutputStream());
            salida.writeObject(new Cliente(id, password));
            entrada = new ObjectInputStream(socket.getInputStream());
            Cliente clienteEncontrado = (Cliente) entrada.readObject();
            salida.close();
            socket.close();
            entrada.close();
            return clienteEncontrado;
        } catch (ClassNotFoundException | IOException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "No se puede conectar al servidor: " + ex);
            return null;
        }
    }

    public ArrayList<Zapato> pedirCatalogo(ArrayList<Zapato> catalogo) throws IOException {
        try {
            socket = new Socket(ip, puerto);
            salida = new ObjectOutputStream(socket.getOutputStream());
            salida.writeObject(catalogo);
            System.out.println("Se mando a pedir catalogo");
            entrada = new ObjectInputStream(socket.getInputStream());
            catalogo = (ArrayList<Zapato>) entrada.readObject();
            System.out.println("Numero de elementos recibidos del catalogo " + catalogo.size());
            socket.close();
            salida.close();
            entrada.close();
            recibirFotos(catalogo);
            return catalogo;
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
            return null;
        }
    }

    public void cerrarSession() {
        try {
            socket = new Socket(ip, puerto);
            salida = new ObjectOutputStream(socket.getOutputStream());
            salida.writeObject(false);
            System.out.println("Se mando a cerrar session");
            salida.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void actualizarPorCompra(ArrayList<Compra> lista) {
        try {
            socket = new Socket(ip, puerto);
            salida = new ObjectOutputStream(socket.getOutputStream());
            salida.writeObject(lista);
            System.out.println("Se mando realizar actualizar por compra");
            salida.close();
            socket.close();
            JOptionPane.showMessageDialog(null, "Se realizo la compra con exito", "Exito", JOptionPane.OK_OPTION);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private void recibirFotos(ArrayList<Zapato> catalogo) {
        try {
            server = new ServerSocket(9090);
            for (int i = 0; i < catalogo.size(); i++) {
                System.out.println("Esperando imagen " + catalogo.get(i).getArchivo());
                socketFoto = server.accept();
                receivedData = new byte[1024];
                bis = new BufferedInputStream(socketFoto.getInputStream());
                bos = new BufferedOutputStream(new FileOutputStream("imagenesCliente/" + catalogo.get(i).getArchivo()));
                while ((in = bis.read(receivedData)) != -1) {
                    bos.write(receivedData, 0, in);
                }
                System.out.println("Imagen recibida en el cliente " + catalogo.get(i).getArchivo());
                bos.close();
                bis.close();
                socketFoto.close();
            }
            server.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Error al enviar archivo " + ex);
        } catch (IOException ex) {
            System.err.println("Error en el flujo " + ex);
        }
    }
}
