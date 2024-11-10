package com.finance.app.invoices.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Float tipo_cambio;

    public Moneda(String  nombre, Float tipo_cambio) {
        this.nombre = nombre;
        this.tipo_cambio = tipo_cambio;
    }

}
