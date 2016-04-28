package Cliente.controlador;

import Cliente.modelo.Cliente;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TicketPDF {

    public static void crearPdf(JTable tablaCarrito, int numero, Cliente cliente) throws FileNotFoundException, DocumentException {
        int total = 0;
        try {
            java.util.Date fecha = new Date();
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream("archivos/Ticket"+numero+".pdf"));
            documento.open();
            documento.addTitle("Ticket");
            documento.addAuthor("Fernanda");
            documento.addCreationDate();
            //Agregar el titulo al ticket
            Paragraph titulo = new Paragraph("Tienda Online SA DE CV\n", new Font(Font.FontFamily.HELVETICA, 28));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            //Agregar la fecha actual y numero del ticket
            Paragraph fechaActual = new Paragraph("Fecha: " + fecha.toGMTString() + "\nTicket: 00" + numero + "\nCajero: 001\n\n", new Font(Font.FontFamily.HELVETICA, 14));
            fechaActual.setAlignment(Element.ALIGN_CENTER);
            documento.add(fechaActual);
            //Agregar los datos del cliente
            Paragraph datos = new Paragraph("Cliente: " + cliente.getNombre() + " " + cliente.getApellidoPaterno() + " "+ cliente.getApellidoMaterno() +"\n\n ", new Font(Font.FontFamily.HELVETICA, 12));
            datos.setAlignment(Element.ALIGN_CENTER);
            documento.add(datos);
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID");
            tabla.addCell("PRODUCTO");
            tabla.addCell("CANTIDAD");
            tabla.addCell("PRECIO UNITARIO");
            tabla.addCell("PRECIO TOTAL");
            //Obtener los datos de la tabla
            for (int i = 0; i < tablaCarrito.getRowCount(); i++) {
                tabla.addCell("" + tablaCarrito.getValueAt(i, 0));//este regresa el valor id de la fila i
                tabla.addCell("" + tablaCarrito.getValueAt(i, 1));//este regresa el valor zapato de la fila i
                tabla.addCell("" + tablaCarrito.getValueAt(i, 2));//este regresa el valor cantidad de la fila i
                tabla.addCell("" + tablaCarrito.getValueAt(i, 3));//este regresa el valor precio unitario de la fila i
                tabla.addCell("" + tablaCarrito.getValueAt(i, 4));//este regresa el valor precio total de la fila i
                total = total + (Integer.valueOf(String.valueOf(tablaCarrito.getValueAt(i, 4))));
            }
            String tot = Integer.toString(total);
            tabla.addCell("TOTAL");
            tabla.addCell("");
            tabla.addCell("");
            tabla.addCell("");
            tabla.addCell("" + tot);
            documento.add(tabla);
            Image img;
            img = Image.getInstance("imagenes/barcode09.gif");
            img.setAlignment(Image.ALIGN_CENTER);
            documento.add(img);
            Paragraph pie = new Paragraph("\n\nVuelva pronto\nHasta luego");
            pie.setAlignment(Element.ALIGN_CENTER);
            documento.add(pie);
            documento.close();
            Desktop.getDesktop().open(new File("archivos/Ticket" + numero + ".pdf"));
            Desktop.getDesktop().browse(new URI("archivos"));
        } catch (IOException | URISyntaxException ex) {
            System.err.println(ex);
        }
    }

//    public static void main(String[] args) throws FileNotFoundException, DocumentException {
//        //El main es solo para pobrar que esta jalando los datos de esta tabla que es solo prueba
//        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{
//            {"1", "zapatilla", "5", "500", "2500"}, {"2", "tenis", "2", "200", "400"}
//        }, new String[]{
//            "Id", "Zapato", "Cantidad", "Precio Unitario", "Precio Total"
//        });
//        JTable tablaPrueba = new JTable(modelo);
//        TicketPDF.crearPdf(tablaPrueba);
//    }
}
