package com.pup.taguig.app.service;

import java.util.List;

import com.pup.taguig.app.dto.SalesReportResponseDTO;
import com.pup.taguig.app.dto.TopProductResponseDTO;

public interface ReportService {

    SalesReportResponseDTO getSalesReport();

    List<TopProductResponseDTO> getTopSellingProducts();
}