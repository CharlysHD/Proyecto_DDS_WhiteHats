package com.desarrollo.Spring5.DTOs;
import com.desarrollo.Spring5.entities.Producto;
import com.desarrollo.Spring5.entities.Base;
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
 private Producto producto;
     private BigDecimal ratingInsumo;
     private String denominacion;



}
