package com.desarrollo.Spring3.entities;

import com.desarrollo.Spring3.enums.FormaPago;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura extends Base {

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

    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @NotNull
    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @NotNull
    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @NotNull
    @Column(name = "mp_payment_type")
    private Long mpPaymentType;

    @NotNull
    @Column(name = "mp_preference_id")
    private Long mpPreferenceId;

    @NotNull
    @Column(name = "total_venta", precision = 10, scale = 2)
    private BigDecimal totalVenta;

     @NotNull
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
}  
