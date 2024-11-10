package com.finance.app.reports.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import java.util.Date;

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

    private Integer reporteId;

    public Cartera(Date fechaDescuento, Float tceaCartera, Integer reporteId) {
        this.fechaDescuento = fechaDescuento;
        this.tceaCartera = tceaCartera;
        this.reporteId = reporteId;
    }
}
