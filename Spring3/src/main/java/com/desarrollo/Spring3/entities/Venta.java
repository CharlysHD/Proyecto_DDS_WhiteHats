package com.desarrollo.Spring3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "venta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Venta extends Base {

    @NotNull
    @Column(name = "codigo-venta")
    private int codVenta;

    @NotNull
    @Column(name = "importe-total")
    private float importeTotal;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo-venta")
    private List<VentaFactura> ventaFacturas = new ArrayList<>();
}
