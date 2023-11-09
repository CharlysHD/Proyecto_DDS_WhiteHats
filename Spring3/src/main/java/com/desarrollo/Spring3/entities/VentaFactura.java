package com.desarrollo.Spring3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "venta-factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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
