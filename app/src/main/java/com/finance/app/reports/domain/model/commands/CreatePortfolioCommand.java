package com.finance.app.reports.domain.model.commands;

import java.util.Date;

public record CreatePortfolioCommand(
        Date fechaDescuento,
        Float tceaCartera
) {
}
