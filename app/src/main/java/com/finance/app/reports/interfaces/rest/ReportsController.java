package com.finance.app.reports.interfaces.rest;

import com.finance.app.reports.domain.model.aggregates.Reporte;
import com.finance.app.reports.domain.model.commands.DeleteReportCommand;
import com.finance.app.reports.domain.model.queries.GetAllReportsQuery;
import com.finance.app.reports.domain.model.queries.GetReportByIdQuery;
import com.finance.app.reports.domain.services.ReportCommandService;
import com.finance.app.reports.domain.services.ReportQueryService;
import com.finance.app.reports.interfaces.rest.resources.CreateReportResource;
import com.finance.app.reports.interfaces.rest.resources.ReportResource;
import com.finance.app.reports.interfaces.rest.resources.UpdateReportResource;
import com.finance.app.reports.interfaces.rest.transform.CreateReportCommandFromResourceAssembler;
import com.finance.app.reports.interfaces.rest.transform.ReportResourceFromEntityAssembler;
import com.finance.app.reports.interfaces.rest.transform.UpdateReportCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/reportes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reportes", description = "Reporte endpoints")
public class ReportsController {

    private final ReportQueryService reportQueryService;
    private final ReportCommandService reportCommandService;

    public ReportsController(ReportQueryService reportQueryService, ReportCommandService reportCommandService) {
        this.reportQueryService = reportQueryService;
        this.reportCommandService = reportCommandService;
    }

    @PostMapping
    public ResponseEntity<ReportResource> createReport(@RequestBody CreateReportResource resource) {
        Optional<Reporte> report = reportCommandService.handle(CreateReportCommandFromResourceAssembler.toCommandFromResource(resource));
        return report.map(i-> new ResponseEntity<>(ReportResourceFromEntityAssembler.toResourceFromEntity(i), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @GetMapping
    public ResponseEntity<List<ReportResource>> getAllReports() {
        var reports = reportQueryService.handle(new GetAllReportsQuery());
        if (reports.isEmpty()) return ResponseEntity.notFound().build();
        var reportResources = reports.stream().map(ReportResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reportResources);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReportResource> getReportById(@PathVariable Long id) {
        Optional<Reporte> report = reportQueryService.handle(new GetReportByIdQuery(id));
        return report.map(i -> ResponseEntity.ok(ReportResourceFromEntityAssembler.toResourceFromEntity(i))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ReportResource> updateReport(@PathVariable Long id, @RequestBody UpdateReportResource resource) {
        var updateReportCommand = UpdateReportCommandFromResourceAssembler.toCommandFromResource(id, resource);
        reportCommandService.handle(updateReportCommand);

        var getReportByIdQuery = new GetReportByIdQuery(id);
        var report = reportQueryService.handle(getReportByIdQuery);
        if (report.isEmpty()) return ResponseEntity.notFound().build();
        var reportResource = ReportResourceFromEntityAssembler.toResourceFromEntity(report.get());
        return ResponseEntity.ok(reportResource);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable Long id) {
        try {
            var deleteReportCommand = new DeleteReportCommand(id);
            reportCommandService.handle(deleteReportCommand);
            return ResponseEntity.ok("Reporte eliminado correctamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
