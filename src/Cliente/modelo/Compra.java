
package Cliente.modelo;

import java.io.Serializable;

public class Compra implements Serializable{
    
    int idCompra, cantidad;

    public Compra(int idCompra, int cantidad) {
        this.idCompra = idCompra;
        this.cantidad = cantidad;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
