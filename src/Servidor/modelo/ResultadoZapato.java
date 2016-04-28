
package Servidor.modelo;

public class ResultadoZapato {
    
    private int id,precio,existencia;
    private String descripcion, archivo;

    public ResultadoZapato() {
    }

    public ResultadoZapato(int id, int precio, int existencia, String descripcion, String archivo) {
        this.id = id;
        this.precio = precio;
        this.existencia = existencia;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public ResultadoZapato(int id, int precio, int existencia, String descripcion) {
        this.id = id;
        this.precio = precio;
        this.existencia = existencia;
        this.descripcion = descripcion;
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

    
}
