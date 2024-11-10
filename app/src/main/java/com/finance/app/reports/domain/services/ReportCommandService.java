package com.finance.app.reports.domain.services;

import com.finance.app.reports.domain.model.aggregates.Reporte;
import com.finance.app.reports.domain.model.commands.CreateReportCommand;
import com.finance.app.reports.domain.model.commands.DeleteReportCommand;
import com.finance.app.reports.domain.model.commands.UpdateReportCommand;

import java.util.Optional;

public interface ReportCommandService {
    Optional<Reporte> handle(CreateReportCommand command);
    Optional<Reporte> handle(UpdateReportCommand command);
    Optional<Reporte> handle(DeleteReportCommand command);
}
