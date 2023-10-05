package com.desarrollo.Spring3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rubro")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rubro extends Base {



    @NotNull
    private String denominacion;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;



    @ManyToOne // Muchos rubros pueden tener un rubro padre
    @JoinColumn(name = "rubro_padre_id")
    private Rubro rubroPadre; // Referencia al rubro padre

    @OneToMany(mappedBy = "rubroPadre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Rubro> subRubros = new ArrayList<>();



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro-id")
    //@Builder.Default
    private List<DetalleProducto> detalleProductos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro-id")
    //@Builder.Default
    private List<ArticuloInsumo> articuloInsumos = new ArrayList<>();

    public void agregarArticulos(ArticuloInsumo articulos) {
        articuloInsumos.add(articulos);
    }

    public void mostrarArticulos() {
        System.out.println("Los artículos de este rubro son: ");
        for (ArticuloInsumo articuloInsumo : articuloInsumos) {
            System.out.println("Denominación: " + articuloInsumo.getDenominacion() + "Precio de compra: " + articuloInsumo.getPrecioCompra()
                    + "Stock actual: " + articuloInsumo.getStockActual() + "Stock mínimo: " + articuloInsumo.getStockMinimo() + "Imágen: "
                    + articuloInsumo.getUrlImagen() + "Fecha de baja: " + articuloInsumo.getFechaBaja() + "Fecha de alta: "
                    + articuloInsumo.getFechaAlta() + "Fecha de modificación: " + articuloInsumo.getFechaModificacion());
        }
    }

    public void agregarDetalleProducto(DetalleProducto detallesProd) {
        detalleProductos.add(detallesProd);
    }

}