package com.pup.taguig.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.app.dto.SalesReportResponseDTO;
import com.pup.taguig.app.dto.TopProductResponseDTO;
import com.pup.taguig.app.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/sales")
    public SalesReportResponseDTO getSalesReport() {

        return reportService.getSalesReport();
    }

    @GetMapping("/top-products")
    public List<TopProductResponseDTO> getTopSellingProducts() {

        return reportService.getTopSellingProducts();
    }
}