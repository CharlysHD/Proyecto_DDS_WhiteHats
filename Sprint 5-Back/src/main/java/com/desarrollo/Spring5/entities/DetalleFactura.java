package com.desarrollo.Spring5.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetalleFactura extends Base {

    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne()
    @JoinColumn(name = "id_articulo_insumo")
    private Rubro rubro;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_factura")
    private Factura factura;

}