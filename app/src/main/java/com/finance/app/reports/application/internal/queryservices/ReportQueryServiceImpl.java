package com.finance.app.reports.application.internal.queryservices;

import com.finance.app.reports.domain.model.aggregates.Reporte;
import com.finance.app.reports.domain.model.queries.GetAllReportsQuery;
import com.finance.app.reports.domain.model.queries.GetReportByIdQuery;
import com.finance.app.reports.domain.services.ReportQueryService;
import com.finance.app.reports.infrastructure.persistence.jpa.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportQueryServiceImpl implements ReportQueryService {

    private final ReportRepository reportRepository;

    public ReportQueryServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Reporte> handle(GetAllReportsQuery query) {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Reporte> handle(GetReportByIdQuery query) {
        return reportRepository.findById(query.id());
    }
}
