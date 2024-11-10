package com.finance.app.reports.domain.model.aggregates;
import com.finance.app.reports.domain.model.commands.CreateReportCommand;
import com.finance.app.reports.domain.model.commands.UpdateReportCommand;
import com.finance.app.reports.domain.model.entities.Cartera;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private Date fechaGiro;

    @Getter
    private Date fechaVencimiento;

    @Getter
    private Integer diasTranscurridos;

    @Getter
    private Float valorNominal;

    @Getter
    private Float retencion;

    @Getter
    private Float tasaEfectiva;

    @Getter
    private Float tasaDescuento;

    @Getter
    private Float descuento;

    @Getter
    private Float costeInicial;

    @Getter
    private Float costeFinal;

    @Getter
    private Float valorNeto;

    @Getter
    private Float valorRecibido;

    @Getter
    private Float valorEntregado;

    @Getter
    private Float tcea;

    @Getter
    private Integer facturaId;

    @ManyToOne
    private Cartera cartera;

    public Reporte(){}

    public Reporte(CreateReportCommand command){
        this.fechaGiro = command.fechaGiro();
        this.fechaVencimiento = command.fechaVencimiento();
        this.diasTranscurridos = command.diasTranscurridos();
        this.valorNominal = command.valorNominal();
        this.retencion = command.retencion();
        this.tasaEfectiva = command.tasaEfectiva();
        this.tasaDescuento = command.tasaDescuento();
        this.descuento = command.descuento();
        this.costeInicial = command.costeInicial();
        this.costeFinal = command.costeFinal();
        this.valorNeto = command.valorNeto();
        this.valorRecibido = command.valorRecibido();
        this.valorEntregado = command.valorEntregado();
        this.tcea = command.tcea();
        this.facturaId = command.facturaId();
    }

    public void updateReport(UpdateReportCommand command){
        this.fechaGiro = command.fechaGiro();
        this.fechaVencimiento = command.fechaVencimiento();
        this.diasTranscurridos = command.diasTranscurridos();
        this.valorNominal = command.valorNominal();
        this.retencion = command.retencion();
        this.tasaEfectiva = command.tasaEfectiva();
        this.tasaDescuento = command.tasaDescuento();
        this.descuento = command.descuento();
        this.costeInicial = command.costeInicial();
        this.costeFinal = command.costeFinal();
        this.valorNeto = command.valorNeto();
        this.valorRecibido = command.valorRecibido();
        this.valorEntregado = command.valorEntregado();
        this.tcea = command.tcea();
        this.facturaId = command.facturaId();
    }
}
