package com.finance.app.reports.interfaces.rest.resources;

import java.util.Date;

public record PortfolioResource(
        Long id,
        Date fechaDescuento,
        float tceaCartera,
        Integer reporteId
) {
}
