
package Cliente.modelo;

import java.io.Serializable;

public class Cliente implements Serializable{
    
    private String nombre, apellidoPaterno,apellidoMaterno,sexo, password;
    private int id,edad;

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, int id, String password, int edad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.id = id;
        this.password = password;
        this.edad = edad;
    }

    public Cliente() {
    }
    
    public Cliente(String nombre){
        this.nombre = nombre;
    }

    public Cliente(int id, String password) {
        this.id = id;
        this.password = password;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return "Cliente: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + ", edad: " + edad + ", sexo: " + sexo + "\nId: " + id + ", password: " + password;
    }
}
