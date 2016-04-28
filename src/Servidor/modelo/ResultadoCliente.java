
package Servidor.modelo;

public class ResultadoCliente {
    
    private String nombre, apellidoPaterno,apellidoMaterno,sexo, password;
    private int id,edad;

    public ResultadoCliente(String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, String password, int id, int edad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.password = password;
        this.id = id;
        this.edad = edad;
    }

    public ResultadoCliente() {
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + ", sexo: " + sexo + ", edad: " + ", id: " + id + ", password: " + password; 
    }
    
}
