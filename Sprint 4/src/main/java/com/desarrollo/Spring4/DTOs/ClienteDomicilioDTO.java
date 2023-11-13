package com.desarrollo.Spring4.DTOs;

import lombok.Data;

@Data
public class ClienteDomicilioDTO {
    Long id;
    String calle;
    Integer numero;
    String localidad;
}
