package com.desarrollo.Spring4.DTOs;

import com.desarrollo.Spring4.entities.Base;
import com.desarrollo.Spring4.entities.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DTORatingCliente")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DtoRatingCliente extends Base {
    private Cliente cliente;

    private Integer cantidad;

    private BigDecimal ratingCliente;

    private BigDecimal total;

}
