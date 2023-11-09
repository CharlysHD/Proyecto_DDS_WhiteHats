package com.desarrollo.Spring3.entities;


import com.desarrollo.Spring3.enums.RolEmpleado;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.util.Date;


@Entity
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Empleado extends Base {

    @NotNull
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "telefono")
    private String telefono;

    @NotNull
    @Column(name = "rol")
    private RolEmpleado rolEmpleado;

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

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
