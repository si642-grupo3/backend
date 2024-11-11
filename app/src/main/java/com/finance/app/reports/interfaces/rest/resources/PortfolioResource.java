package com.finance.app.reports.interfaces.rest.resources;

import java.util.Date;
import java.util.List;

public record PortfolioResource(
        Long id,
        Date fecha_descuento,
        float tcea_cartera,
        List<ReportResource> reportes
) {
}
