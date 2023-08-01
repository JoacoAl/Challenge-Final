package com.example.challengefinal.growshop.servicios;

import com.example.challengefinal.growshop.dto.OrdenDTO;
import com.example.challengefinal.growshop.dto.OrdenProductoDTO;
import com.example.challengefinal.growshop.models.Cliente;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
@Service
public class ServicioFacturacion {

    public ByteArrayOutputStream generarFacturaPDF(OrdenDTO orden, Set<OrdenProductoDTO> ordenProductos, Cliente cliente) throws DocumentException, IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);

            // Agregar encabezado de la factura
            Paragraph encabezado = new Paragraph("Factura de compra");
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);

            // Agregar información de la orden (encabezado)
            Paragraph infoOrden = new Paragraph("Número de orden: " + orden.getNumeroDeOrden());
            Paragraph clienteCompra = new Paragraph("Nombre del cliente: " + cliente.getNombre() + " " + cliente.getApellido());
            Paragraph montoTotal = new Paragraph("Monto total de la compra: $" + calcularTotal(ordenProductos));
            document.add(infoOrden);
            document.add(clienteCompra);
            document.add(montoTotal);

            // Agregar tabla con los productos y sus detalles
            Table table = new Table(3);
            table.addCell("Producto");
            table.addCell("Cantidad");
            table.addCell("Precio unitario");

            for (OrdenProductoDTO ordenProducto : ordenProductos) {
                table.addCell(ordenProducto.getNombre());
                table.addCell(String.valueOf(ordenProducto.getCantidadDeProductos()));
                table.addCell(String.valueOf(ordenProducto.getPrecioUnitario()));
            }

            document.add(table);

            // Agregar total de la factura
            Paragraph total = new Paragraph("Total: $" + calcularTotal(ordenProductos));
            document.add(total);

            document.close();
            return outputStream;
    }

    private double calcularTotal(Set<OrdenProductoDTO> ordenProductos) {
        double total = 0;
        for (OrdenProductoDTO ordenProducto : ordenProductos) {
            total += ordenProducto.getCantidadDeProductos() * ordenProducto.getPrecioUnitario();
        }
        return total;
    }
}
