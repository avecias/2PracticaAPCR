
package Cliente.modelo;

import java.io.Serializable;

public class Zapato implements Serializable{
    
    private int id,precio,existencia;
    private String descripcion,archivo;

    public Zapato(int id, int precio, int existencia, String descripcion, String archivo) {
        this.id = id;
        this.precio = precio;
        this.existencia = existencia;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public Zapato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    

    @Override
    public String toString() {
        return "Id: " + id + ", nombre: " + descripcion + ", precio: " + precio + ", existencias: " + existencia;
    }
    
}
