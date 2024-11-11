package com.finance.app.reports.domain.model.entities;

import com.finance.app.reports.domain.model.aggregates.Reporte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Cartera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaDescuento;

    private Float tceaCartera;

    @OneToMany(mappedBy = "cartera", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reporte> reportes = new ArrayList<>();

    public Cartera(Date fechaDescuento, Float tceaCartera) {
        this.fechaDescuento = fechaDescuento;
        this.tceaCartera = tceaCartera;
    }
}
