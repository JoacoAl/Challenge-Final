package com.example.challengefinal.growshop.servicios;

import com.example.challengefinal.growshop.dto.OrdenDTO;
import com.example.challengefinal.growshop.dto.OrdenInfoDTO;
import com.example.challengefinal.growshop.models.Cliente;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

@Service
public class ServicioFacturacion {

    @Autowired
    private EmailSend emailSend;

    public ByteArrayOutputStream generarFacturaPDF(OrdenDTO orden, Set<OrdenInfoDTO> ordenProductos, Cliente cliente) throws IOException, DocumentException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);

            document.open();
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
            PdfPTable table = new PdfPTable(4);
            table.addCell("Producto");
            table.addCell("Cantidad");
            table.addCell("Precio unitario");
            table.addCell("Precio por cantidad");

            for (OrdenInfoDTO ordenProducto : ordenProductos) {
                table.addCell(ordenProducto.getNombre());
                table.addCell(String.valueOf(ordenProducto.getTotalProductos()));
                table.addCell(String.valueOf("$ " + ordenProducto.getTotal()));
                table.addCell(String.valueOf("$ " + ordenProducto.getTotal() * ordenProducto.getTotalProductos()));
            }

            document.add(table);

            // Agregar total de la factura
            Paragraph total = new Paragraph("Total: $" + calcularTotal(ordenProductos));
            document.add(total);

            document.close();
        return outputStream;
    }

    private double calcularTotal(Set<OrdenInfoDTO> ordenProductos) {
        double total = 0;
        for (OrdenInfoDTO ordenProducto : ordenProductos) {
            total += ordenProducto.getTotalProductos() * ordenProducto.getTotal();
        }
        return total;
    }
}

