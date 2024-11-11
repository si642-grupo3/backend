package com.finance.app.invoices.domain.model.aggregates;

import com.finance.app.finalCosts.domain.model.aggregates.CosteFinal;
import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import com.finance.app.invoices.domain.model.commands.CreateInvoiceCommand;
import com.finance.app.invoices.domain.model.commands.UpdateInvoiceCommand;
import com.finance.app.invoices.domain.model.entities.Moneda;
import com.finance.app.invoices.infrastructure.persistence.jpa.CurrencyRepository;
import com.finance.app.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.finance.app.reports.domain.model.aggregates.Reporte;
import com.finance.app.users.domain.model.aggregates.Cliente;
import com.finance.app.users.infrastructure.persistance.jpa.ClientRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Factura extends AuditableAbstractAggregateRoot<Factura> {

    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String numero;

    @Getter
    private Date fecha_emision;

    @Getter
    private Date fecha_pago;

    @Getter
    private Float retencion;

    @Getter
    private Float total_facturado;

    @Getter
    private Float igv = 0.18f;

    @Getter
    private Integer dias_anio;

    @Getter
    private Integer plazo_tasa;

    @Getter
    private Float tasa_nominal;

    @Getter
    private Float tasa_efectiva;

    @Getter
    private Integer periodo_capitalizacion;

    @Getter
    private Date fecha_descuento;

    @OneToOne(fetch = FetchType.EAGER)
    private Moneda Moneda;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CosteInicial> costesIniciales = new ArrayList<>();

    @OneToMany(mappedBy = "factura", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CosteFinal> costesFinales = new ArrayList<>();

    @OneToOne(mappedBy = "factura", cascade = CascadeType.ALL)
    private Reporte reporte;

    public Factura() {this.Moneda = new Moneda();}

    public Factura(CreateInvoiceCommand command, CurrencyRepository currencyRepository, ClientRepository clientRepository) {
        this.numero = command.numero();
        this.fecha_emision = command.fecha_emision();
        this.fecha_pago = command.fecha_pago();
        this.retencion = command.retencion();
        this.total_facturado = command.total_facturado();
        this.dias_anio = command.dias_anio();
        this.plazo_tasa = command.plazo_tasa();
        this.tasa_nominal = command.tasa_nominal();
        this.tasa_efectiva = command.tasa_efectiva();
        this.periodo_capitalizacion = command.periodo_capitalizacion();
        this.fecha_descuento = command.fecha_descuento();
        this.Moneda = currencyRepository.findById(command.moneda())
                .orElseThrow(() -> new EntityNotFoundException("Currency not found"));
        this.cliente = clientRepository.findById(command.cliente())
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    public void UpdateInvoice(UpdateInvoiceCommand command, CurrencyRepository currencyRepository) {
        this.fecha_emision = command.fecha_emision();
        this.fecha_pago = command.fecha_pago();
        this.retencion = command.retencion();
        this.total_facturado = command.total_facturado();
        this.dias_anio = command.dias_anio();
        this.plazo_tasa = command.plazo_tasa();
        this.tasa_nominal = command.tasa_nominal();
        this.tasa_efectiva = command.tasa_efectiva();
        this.periodo_capitalizacion = command.periodo_capitalizacion();
        this.fecha_descuento = command.fecha_descuento();
        this.Moneda = currencyRepository.findById(command.moneda())
                .orElseThrow(() -> new EntityNotFoundException("Currency not found"));
    }

}
