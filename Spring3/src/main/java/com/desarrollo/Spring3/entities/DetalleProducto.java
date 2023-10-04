package com.desarrollo.Spring3.entities;

import com.desarrollo.Spring3.enums.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleProducto extends Base {

    @NotNull
    @Column(name = "cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;

    @NotNull
    @Column(name = "receta")
    private String receta;

    @NotNull
    @Column(name = "rating")
    private Rating rating;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_articulo_insumo")
    private ArticuloInsumo articuloInsumo;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_prodcuto")
    private Producto producto;

}