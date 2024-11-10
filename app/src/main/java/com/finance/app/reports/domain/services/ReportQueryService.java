package com.finance.app.reports.domain.services;
import com.finance.app.reports.domain.model.aggregates.Reporte;
import com.finance.app.reports.domain.model.queries.GetAllReportsQuery;
import com.finance.app.reports.domain.model.queries.GetReportByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReportQueryService {
    List<Reporte> handle(GetAllReportsQuery query);
    Optional<Reporte> handle(GetReportByIdQuery query);
}
