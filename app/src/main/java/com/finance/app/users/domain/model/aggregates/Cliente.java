package com.finance.app.users.domain.model.aggregates;

import com.finance.app.invoices.domain.model.aggregates.Factura;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Cliente extends AbstractAggregateRoot<Cliente> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String nombre;

    @Getter
    private String apellido;

    @Getter
    private String ruc;

    @Getter
    private String telefono;

    @Getter
    private String direccion;

    @Getter
    private String email;

    @Getter
    private String password;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Factura> facturas = new ArrayList<>();

    public Cliente(){}

    public Cliente(String nombre, String apellido, String ruc, String telefono, String direccion, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
    }
}
