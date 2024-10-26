package com.upiiz.cam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 3, message = "El nombre del cliente debe tener mínimo 3 caracteres")
    @Column(name = "nombre_cliente")
    private String nombre;

    @NotBlank(message = "Se debe ingresar un apellido")
    private String apellidos;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "[0-9]{10}", message = "El teléfono debe tener exactamente 10 dígitos")
    private String telefono;

    @NotBlank
    private String direccion;

    @Min(18)
    private int edad;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{4}\\d{6}[A-Z0-9]{3}$", message = "El RFC debe ser válido")
    private String rfc;
}