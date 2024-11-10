package com.finance.app.reports.domain.model.queries;

public record GetReportByIdQuery(Long id){
    public GetReportByIdQuery{
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }
    }
}
