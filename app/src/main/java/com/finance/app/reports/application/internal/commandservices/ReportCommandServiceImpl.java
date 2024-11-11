package com.finance.app.reports.application.internal.commandservices;

import com.finance.app.invoices.infrastructure.persistence.jpa.InvoiceRepository;
import com.finance.app.reports.domain.model.aggregates.Reporte;
import com.finance.app.reports.domain.model.commands.CreateReportCommand;
import com.finance.app.reports.domain.model.commands.DeleteReportCommand;
import com.finance.app.reports.domain.model.commands.UpdateReportCommand;
import com.finance.app.reports.domain.services.ReportCommandService;
import com.finance.app.reports.infrastructure.persistence.jpa.PortfolioRepository;
import com.finance.app.reports.infrastructure.persistence.jpa.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportCommandServiceImpl implements ReportCommandService {

    private final ReportRepository reportRepository;
    private final InvoiceRepository invoiceRepository;
    private final PortfolioRepository portfolioRepository;

    public ReportCommandServiceImpl( ReportRepository reportRepository, InvoiceRepository invoiceRepository, PortfolioRepository portfolioRepository) {
        this.reportRepository = reportRepository;
        this.invoiceRepository = invoiceRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public Optional<Reporte> handle(CreateReportCommand command) {
        /*add verification of existing report with id*/
        var report = new Reporte(command, invoiceRepository, portfolioRepository);
        var createdReport = reportRepository.save(report);
        return Optional.of(createdReport);
    }

    @Override
    public Optional<Reporte> handle(UpdateReportCommand command) {
        var report = reportRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));
        report.updateReport(command, invoiceRepository, portfolioRepository);
        var updatedReport = reportRepository.save(report);
        return Optional.of(updatedReport);
    }

    @Override
    public Optional<Reporte> handle(DeleteReportCommand command) {
        var report = reportRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));
        reportRepository.delete(report);
        return Optional.of(report);
    }
}
