package com.finance.app.invoices.domain.model.aggregates;

import com.finance.app.invoices.domain.model.commands.CreateInvoiceCommand;
import com.finance.app.invoices.domain.model.commands.UpdateInvoiceCommand;
import com.finance.app.invoices.domain.model.entities.Moneda;
import com.finance.app.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Moneda Moneda;

    /*
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Integer Cliente;*/

    public Factura() {this.Moneda = new Moneda();}

    public Factura(CreateInvoiceCommand command) {
        this.numero = command.numero();
        this.fecha_emision = command.fecha_emision();
        this.fecha_pago = command.fecha_pago();
        this.retencion = command.retencion();
        this.total_facturado = command.total_facturado();
        this.Moneda = command.Moneda();
    }

    public void UpdateInvoice(UpdateInvoiceCommand command) {
        this.fecha_emision = command.fecha_emision();
        this.fecha_pago = command.fecha_pago();
        this.retencion = command.retencion();
        this.total_facturado = command.total_facturado();
        this.Moneda = command.Moneda();
    }

}
