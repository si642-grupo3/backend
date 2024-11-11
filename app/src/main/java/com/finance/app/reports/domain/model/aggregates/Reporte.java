package com.finance.app.reports.domain.model.aggregates;
import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.infrastructure.persistence.jpa.InvoiceRepository;
import com.finance.app.reports.domain.model.commands.CreateReportCommand;
import com.finance.app.reports.domain.model.commands.UpdateReportCommand;
import com.finance.app.reports.domain.model.entities.Cartera;
import com.finance.app.reports.infrastructure.persistence.jpa.PortfolioRepository;
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

    @OneToOne
    @JoinColumn(name = "factura_id", referencedColumnName = "id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "cartera_id")
    private Cartera cartera;

    public Reporte(){}

    public Reporte(CreateReportCommand command, InvoiceRepository invoiceRepository, PortfolioRepository portfolioRepository){
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
        this.factura = invoiceRepository.findById(command.factura_id())
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
        this.cartera = portfolioRepository.findById(command.cartera_id())
                .orElseThrow(() -> new EntityNotFoundException("Portfolio not found"));
    }

    public void updateReport(UpdateReportCommand command, InvoiceRepository invoiceRepository, PortfolioRepository portfolioRepository){
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
        this.factura = invoiceRepository.findById(command.factura_id())
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
        this.cartera = portfolioRepository.findById(command.cartera_id())
                .orElseThrow(() -> new EntityNotFoundException("Portfolio not found"));
    }
}
