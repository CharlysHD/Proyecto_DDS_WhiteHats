package com.desarrollo.Spring3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "venta-factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VentaFactura extends Base {

    private int cantidadVentaFactura;

    @NotNull
    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHasta;

    @NotNull
    @Column(name = "fecha_desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesde;

    @ManyToOne
    @JoinColumn(name = "venta-factura-id")
    private Factura factura;

}
