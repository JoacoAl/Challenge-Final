package com.example.challengefinal.growshop.dto;

import com.example.challengefinal.growshop.models.Pago;
import com.example.challengefinal.growshop.models.TipoDePago;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PagoDTO {

    private Long id;

    private TipoDePago tipoDePago;

    private LocalDateTime fecha;


    public PagoDTO(){}

    public PagoDTO(Pago pago) {
        this.id = pago.getId();
        this.tipoDePago = pago.getTipoDePago();
        this.fecha = pago.getFechaDePago();
    }

    public Long getId() {
        return id;
    }

    public TipoDePago getTipoDePago() {
        return tipoDePago;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
