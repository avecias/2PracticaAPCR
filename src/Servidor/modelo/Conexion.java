package modelo;

import Cliente.modelo.Cliente;
import Cliente.modelo.Compra;
import Cliente.modelo.Zapato;
import Servidor.modelo.ResultadoCliente;
import Servidor.modelo.ResultadoZapato;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Conexion {

    public String BUSCAR_CLIENTE = "SELECT * FROM cliente WHERE id_cliente = ? && password = ?";
    public String BUSCAR_ZAPATOS = "SELECT * FROM zapato";
    public String BUSCAR_CLIENTES = "SELECT * FROM cliente";
    public String ACTUALIZAR_ZAPATO_COMPRA = "UPDATE zapato SET existencia = (existencia - ?) WHERE id_zapato = ?";
    public String ACTUALIZAR_CLIENTE = "UPDATE cliente SET nombre=?, paterno=?, materno=?, sexo=?, password=?, edad=? WHERE id_cliente = ?";
    public String ACTUALIZAR_ZAPATO = "UPDATE zapato SET precio=?, existencia=?, descripcion=? WHERE id_zapato=?";
    public String CREAR_CLIENTE = "INSERT INTO cliente (nombre,materno,paterno,sexo,password,edad) VALUES(?,?,?,?,?,?)";
    public String CREAR_ZAPATO = "INSERT INTO zapato (precio,existencia,descripcion,archivo) VALUES(?,?,?,?)";
    public String BORRAR_CLIENTE = "DELETE FROM cliente WHERE id_cliente = ?";
    public String BORRAR_ZAPATO = "DELETE FROM zapato WHERE id_zapato = ?";
    private Connection conexion;
    private PreparedStatement prepareStatement;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/practica2", "root", "kksmells");
            System.out.println("Conexion exitosa a la base de datos");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error intentelo otra vvez");
        } finally { // Se cierra la conexión con la base de da
        }
    }

    public Cliente buscarCliente(Cliente cliente,JTextArea area) throws SQLException {
        int id = cliente.getId();
        String password = cliente.getPassword();
        prepareStatement = conexion.prepareStatement(BUSCAR_CLIENTE);
        prepareStatement.setInt(1, id);
        prepareStatement.setString(2, password);
        ResultSet consulta = prepareStatement.executeQuery();
        if (!consulta.next()) {
            area.append("\nCliente no encontrado");
            return new Cliente("");
        } else {
            area.append("\nCliente encontrado");
            Cliente clienteEncontrado = new Cliente();
            clienteEncontrado.setId(id);
            clienteEncontrado.setPassword(password);
            clienteEncontrado.setNombre(consulta.getString("NOMBRE"));
            clienteEncontrado.setApellidoPaterno(consulta.getString("PATERNO"));
            clienteEncontrado.setApellidoMaterno(consulta.getString("MATERNO"));
            clienteEncontrado.setSexo(consulta.getString("SEXO"));
            clienteEncontrado.setEdad(consulta.getInt("EDAD"));
            System.out.println(clienteEncontrado.toString());
            return clienteEncontrado;
        }
    }

    public ArrayList<Zapato> llenarCatalogo(ArrayList<Zapato> catalogo) {
        try {
            prepareStatement = conexion.prepareStatement(BUSCAR_ZAPATOS);
            ResultSet consulta = prepareStatement.executeQuery();
            catalogo.clear();
            while (consulta.next()) {
                Zapato zapato = new Zapato();
                zapato.setId(consulta.getInt("ID_ZAPATO"));
                zapato.setPrecio(consulta.getInt("PRECIO"));
                zapato.setExistencia(consulta.getInt("EXISTENCIA"));
                zapato.setDescripcion(consulta.getString("DESCRIPCION"));
                zapato.setArchivo(consulta.getString("ARCHIVO"));
                catalogo.add(zapato);
            }
            System.out.println("Catalogo llenado de la base de datos");
            return catalogo;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    public void crearCliente(String nombre, String apellidos, String telefono) {
        try {
            prepareStatement = conexion.prepareStatement(CREAR_CLIENTE);
            prepareStatement.setString(1, nombre);
            prepareStatement.setString(2, apellidos);
            prepareStatement.setString(3, telefono);
            if (PreparedStatement.EXECUTE_FAILED != prepareStatement.executeUpdate()) {
                System.out.println("exito");
            } else {
                System.out.println("no exito");
            }
            prepareStatement.clearParameters();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public ArrayList<ResultadoCliente> selectCliente(ArrayList<ResultadoCliente> clientes) {
        try {
            prepareStatement = conexion.prepareStatement(BUSCAR_CLIENTES);
            ResultSet resultado = prepareStatement.executeQuery();
            while (resultado.next()) {
                ResultadoCliente cliente = new ResultadoCliente();
                cliente.setId(resultado.getInt("ID_CLIENTE"));
                cliente.setNombre(resultado.getString("NOMBRE"));
                cliente.setApellidoPaterno(resultado.getString("PATERNO"));
                cliente.setApellidoMaterno(resultado.getString("MATERNO"));
                cliente.setSexo(resultado.getString("SEXO"));
                cliente.setPassword(resultado.getString("PASSWORD"));
                cliente.setEdad(resultado.getInt("EDAD"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            System.err.println(ex);
            return clientes;
        }
    }

    public ArrayList<ResultadoZapato> selectZapato(ArrayList<ResultadoZapato> zapatos) {
        try {
            prepareStatement = conexion.prepareStatement(BUSCAR_ZAPATOS);
            ResultSet resultado = prepareStatement.executeQuery();
            while (resultado.next()) {
                ResultadoZapato zapato = new ResultadoZapato();
                zapato.setId(resultado.getInt("ID_ZAPATO"));
                zapato.setPrecio(resultado.getInt("PRECIO"));
                zapato.setExistencia(resultado.getInt("EXISTENCIA"));
                zapato.setDescripcion(resultado.getString("DESCRIPCION"));
                zapato.setArchivo(resultado.getString("ARCHIVO"));
                zapatos.add(zapato);
            }
            return zapatos;
        } catch (SQLException ex) {
            System.err.println(ex);
            return zapatos;
        }
    }

    public boolean insertarCliente(ResultadoCliente cliente) {
        try {
            prepareStatement = conexion.prepareStatement(CREAR_CLIENTE);
            prepareStatement.setString(1, cliente.getNombre());
            prepareStatement.setString(2, cliente.getApellidoPaterno());
            prepareStatement.setString(3, cliente.getApellidoMaterno());
            prepareStatement.setString(4, cliente.getSexo());
            prepareStatement.setString(5, cliente.getPassword());
            prepareStatement.setInt(6, cliente.getEdad());
            return prepareStatement.executeUpdate() != PreparedStatement.EXECUTE_FAILED;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean borrarCliente(int id) {
        try {
            prepareStatement = conexion.prepareStatement(BORRAR_CLIENTE);
            prepareStatement.setInt(1, id);
            return prepareStatement.executeUpdate() != PreparedStatement.EXECUTE_FAILED;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public boolean modificarCliente(ResultadoCliente cliente, int idUpdate) {
        try {
            prepareStatement = conexion.prepareStatement(ACTUALIZAR_CLIENTE);
            prepareStatement.setString(1, cliente.getNombre());
            prepareStatement.setString(2, cliente.getApellidoPaterno());
            prepareStatement.setString(3, cliente.getApellidoMaterno());
            prepareStatement.setString(4, cliente.getSexo());
            prepareStatement.setString(5, cliente.getPassword());
            prepareStatement.setInt(6, cliente.getEdad());
            prepareStatement.setInt(7, idUpdate);
            return prepareStatement.executeUpdate() != PreparedStatement.EXECUTE_FAILED;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean insertarZapato(ResultadoZapato zapato) {
        try {
            prepareStatement = conexion.prepareStatement(CREAR_ZAPATO);
            prepareStatement.setInt(1, zapato.getPrecio());
            prepareStatement.setInt(2, zapato.getExistencia());
            prepareStatement.setString(3, zapato.getDescripcion());
            prepareStatement.setString(4, zapato.getArchivo());
            return prepareStatement.executeUpdate() != PreparedStatement.EXECUTE_FAILED;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean actualizarPorCompra(ArrayList<Compra> lista) {
        try {
            boolean exito = false;
            for (Compra compra : lista) {
                prepareStatement = conexion.prepareStatement(ACTUALIZAR_ZAPATO_COMPRA);
                prepareStatement.setInt(1, compra.getCantidad());
                prepareStatement.setInt(2, compra.getIdCompra());
                exito = prepareStatement.executeUpdate() != PreparedStatement.EXECUTE_FAILED;
            }
            return exito;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public boolean borrarZapato(int id) {
        try {
            prepareStatement = conexion.prepareStatement(BORRAR_ZAPATO);
            prepareStatement.setInt(1, id);
            return prepareStatement.executeUpdate() != PreparedStatement.EXECUTE_FAILED;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public boolean modificarZapato(ResultadoZapato zapato, int idUpdate) {
        try {
            prepareStatement = conexion.prepareStatement(ACTUALIZAR_ZAPATO);
            prepareStatement.setInt(1, zapato.getPrecio());
            prepareStatement.setInt(2, zapato.getExistencia());
            prepareStatement.setString(3, zapato.getDescripcion());
            prepareStatement.setInt(4, idUpdate);
            return prepareStatement.executeUpdate() != PreparedStatement.EXECUTE_FAILED;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

}
