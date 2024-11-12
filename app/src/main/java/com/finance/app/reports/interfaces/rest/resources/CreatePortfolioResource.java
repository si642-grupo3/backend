package com.finance.app.reports.interfaces.rest.resources;

import java.util.Date;

public record CreatePortfolioResource(
        Date fechaDescuento,
        Float tceaCartera
) {
}
