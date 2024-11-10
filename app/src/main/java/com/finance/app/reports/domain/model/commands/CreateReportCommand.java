package com.finance.app.reports.domain.model.commands;

import java.util.Date;

public record CreateReportCommand(
    Date fechaGiro,
    Date fechaVencimiento,
    Integer diasTranscurridos,
    Float valorNominal,
    Float retencion,
    Float tasaEfectiva,
    Float tasaDescuento,
    Float descuento,
    Float costeInicial,
    Float costeFinal,
    Float valorNeto,
    Float valorRecibido,
    Float valorEntregado,
    Float tcea,
    Integer facturaId
) {
    public CreateReportCommand {
        if (fechaGiro == null) {
            throw new IllegalArgumentException("fechaGiro is required");
        }
        if (fechaVencimiento == null) {
            throw new IllegalArgumentException("fechaVencimiento is required");
        }
        if (diasTranscurridos == null) {
            throw new IllegalArgumentException("diasTranscurridos is required");
        }
        if (valorNominal == null) {
            throw new IllegalArgumentException("valorNominal is required");
        }
        if (retencion == null) {
            throw new IllegalArgumentException("retencion is required");
        }
        if (tasaEfectiva == null) {
            throw new IllegalArgumentException("tasaEfectiva is required");
        }
        if (tasaDescuento == null) {
            throw new IllegalArgumentException("tasaDescuento is required");
        }
        if (descuento == null) {
            throw new IllegalArgumentException("descuento is required");
        }
        if (costeInicial == null) {
            throw new IllegalArgumentException("costeInicial is required");
        }
        if (costeFinal == null) {
            throw new IllegalArgumentException("costeFinal is required");
        }
        if (valorNeto == null) {
            throw new IllegalArgumentException("valorNeto is required");
        }
        if (valorRecibido == null) {
            throw new IllegalArgumentException("valorRecibido is required");
        }
        if (valorEntregado == null) {
            throw new IllegalArgumentException("valorEntregado is required");
        }
        if (tcea == null) {
            throw new IllegalArgumentException("tcea is required");
        }
        if (facturaId == null) {
            throw new IllegalArgumentException("facturaId is required");
        }
    }
}
