package com.desarrollo.Spring4.DTOs;

import com.desarrollo.Spring4.entities.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DTORatingProducto")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DTORatingProducto extends Base {

     private BigDecimal ratingInsumo;
     private String denominacion;



}
